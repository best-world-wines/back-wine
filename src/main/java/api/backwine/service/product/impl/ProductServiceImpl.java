package api.backwine.service.product.impl;

import api.backwine.model.product.Product;
import api.backwine.repository.product.ProductRepository;
import api.backwine.repository.product.specification.SpecificationManager;
import api.backwine.repository.product.pageable.PageManager;
import api.backwine.service.product.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProductServiceImpl extends GenericProductServiceImpl<Product>
        implements ProductService<Product> {
    protected ProductServiceImpl(ProductRepository productRepository, PageManager pageManager,
                                 SpecificationManager<Product> specificationManager) {
        super(Product.class, pageManager, productRepository, specificationManager);
    }
}
