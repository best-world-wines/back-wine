package api.backwine.service.product.impl;

import api.backwine.model.product.Product;
import api.backwine.repository.abstraction.GenericProductRepository;
import api.backwine.repository.product.cpecification.SpecificationManager;
import api.backwine.repository.product.pageable.PageManager;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.product.ProductService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public abstract class GenericProductServiceImpl<ENTITY extends Product>
        extends GenericTimestampedServiceImpl<ENTITY, Long> implements ProductService<ENTITY> {
    private final PageManager pageManager;
    private final GenericProductRepository<ENTITY> productRepository;
    private final SpecificationManager<ENTITY> specificationManager;

    protected GenericProductServiceImpl(Class<ENTITY> clazz, PageManager pageManager,
                                        GenericProductRepository<ENTITY> productRepository,
                                        SpecificationManager<ENTITY> specificationManager) {
        super(clazz, productRepository);
        this.pageManager = pageManager;
        this.productRepository = productRepository;
        this.specificationManager = specificationManager;
    }

    @Override
    public Map<Long, ENTITY> getAllByIds(List<Long> ids) {
        return productRepository.findAllByIdAndDeletingDateIsNull(ids).stream()
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
    public Page<ENTITY> getAll(Map<String, String> params) {
        Pageable pageable = pageManager.getPageable(params.remove("size"),
                params.remove("page"), params.remove("sort"));
        Specification<ENTITY> specification = null;
        for (Map.Entry<String, String> param : params.entrySet()) {
            Specification<ENTITY> spec = specificationManager.get(param.getKey(),
                    param.getValue().split(","));
            specification = specification == null ? Specification.where(spec) :
                    specification.and(spec);
        }
        return productRepository.findAll(specification, pageable);
    }
}
