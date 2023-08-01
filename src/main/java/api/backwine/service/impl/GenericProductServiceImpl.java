package api.backwine.service.impl;

import api.backwine.model.Product;
import api.backwine.repository.abstraction.GenericProductRepository;
import api.backwine.service.ProductService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class GenericProductServiceImpl<T extends Product>
        extends SoftDeleteGenericServiceImpl<T, Long> implements ProductService<T> {
    private final GenericProductRepository<T> productRepository;

    protected GenericProductServiceImpl(Class<T> clazz,
                                        GenericProductRepository<T> productRepository) {
        super(clazz, productRepository);
        this.productRepository = productRepository;
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
    public Page<T> getAll(Pageable pageable) {
        return productRepository.findAllByIsDeletedFalse(pageable);
    }
}
