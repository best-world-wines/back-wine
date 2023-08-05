package api.backwine.service.product;

import api.backwine.model.product.Product;
import api.backwine.repository.abstraction.GenericProductRepository;
import api.backwine.repository.product.cpecification.SpecificationManager;
import api.backwine.repository.product.pageable.PageManager;
import api.backwine.service.impl.SoftDeleteGenericServiceImpl;
import api.backwine.service.product.ProductService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericProductServiceImpl<T extends Product>
        extends SoftDeleteGenericServiceImpl<T, Long> implements ProductService<T> {
    private final PageManager pageManager;
    private final GenericProductRepository<T> productRepository;
    private final SpecificationManager<T> specificationManager;

    protected GenericProductServiceImpl(Class<T> clazz, PageManager pageManager,
                                        GenericProductRepository<T> productRepository,
                                        SpecificationManager<T> specificationManager) {
        super(clazz, productRepository);
        this.pageManager = pageManager;
        this.productRepository = productRepository;
        this.specificationManager = specificationManager;
    }

    @Override
    public Map<Long, T> getAllByIdAndIsDeletedFalse(List<Long> ids) {
        return productRepository.findAllByIdAndIsDeletedFalse(ids).stream()
                .collect(Collectors.toMap(Product::getId, product -> product));
    }

    @Override
    public boolean updateQuantity(Long id, Integer quantity) {
        return productRepository.updateQuantity(id, quantity) == 1;
    }

    @Override
    public boolean updateAvailability(List<Long> ids, Boolean isAvailable) {
        return productRepository.updateAvailability(ids, isAvailable) == 1;
    }

    @Override
    public Integer getActualQuantity(Long id) {
        return productRepository.getActualQuantity(id);
    }

    @Override
    public Page<T> getAll(Map<String, String> params) {
        Pageable pageable = pageManager.getPageable(params.remove("size"),
                params.remove("page"), params.remove("sort"));
        Specification<T> specification = null;
        for (Map.Entry<String, String> param : params.entrySet()) {
            Specification<T> spec = specificationManager.get(param.getKey(),
                    param.getValue().split(","));
            specification = specification == null ? Specification.where(spec) :
                    specification.and(spec);
        }
        return productRepository.findAll(specification, pageable);
    }
}
