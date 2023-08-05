package api.backwine.repository.product;

import api.backwine.model.product.Product;
import api.backwine.repository.abstraction.GenericProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericProductRepository<Product> {
    @Query("SELECT p FROM Product p WHERE p.id IN :ids AND p.isDeleted = false")
    List<Product> findAllByIdAndIsDeletedFalse(List<Long> ids);

    @Query("SELECT p.quantityInStock FROM Product p WHERE p.id = :id")
    Integer getActualQuantity(Long id);

    @Modifying
    @Query("UPDATE Product p SET p.quantityInStock = :quantity WHERE p.id = :id")
    int updateQuantity(Long id, Integer quantity);

    @Modifying
    @Query("UPDATE Product p SET p.isEmpty = :isAvailable WHERE p.id IN :ids")
    int updateAvailability(List<Long> ids, Boolean isAvailable);

    @EntityGraph(attributePaths = {"images"})
    Optional<Product> findByIdAndIsDeletedFalse(Long id);

    Page<Product> findAllByIsDeletedFalse(Pageable pageable);
}
