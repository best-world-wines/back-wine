package api.backwine.repository.product;

import api.backwine.model.wine.Wine;
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
public interface WineRepository extends GenericProductRepository<Wine> {
    @Query("SELECT w.quantityInStock FROM Wine w WHERE w.id = :id")
    Integer getActualQuantity(Long id);

    @Modifying
    @Query("UPDATE Wine w SET w.quantityInStock = :quantity WHERE w.id = :id")
    int updateQuantity(Long id, Integer quantity);

    @Modifying
    @Query("UPDATE Wine w SET w.isEmpty = :isAvailable WHERE w.id IN :ids")
    int updateAvailability(List<Long> ids, Boolean isAvailable);

    @EntityGraph(attributePaths = {"images"})
    Optional<Wine> findByIdAndIsDeletedFalse(Long id);

    Page<Wine> findAllByIsDeletedFalse(Pageable pageable);

    @Query("SELECT w FROM Wine w WHERE w.id IN :ids AND w.isDeleted = false")
    List<Wine> findAllByIdAndIsDeletedFalse(List<Long> ids);
}
