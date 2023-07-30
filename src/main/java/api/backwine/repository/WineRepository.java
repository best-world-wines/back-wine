package api.backwine.repository;

import api.backwine.model.Wine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends SoftDeleteRepository<Wine, Long> {
    @Query("SELECT w.quantityInStock FROM Wine w WHERE w.id = :id")
    Integer getActualQuantity(Long id);

    @Modifying
    @Query("UPDATE Wine w SET w.quantityInStock = :quantity WHERE w.id = :id")
    boolean updateQuantity(Long id, Integer quantity);

    @Modifying
    @Query("UPDATE Wine w SET w.isEmpty = :isAvailable WHERE w.id IN :ids")
    boolean updateAvailability(List<Long> ids, Boolean isAvailable);

    //    @Query("SELECT w FROM Wine w " +
//            "LEFT JOIN FETCH w.wineStyle " +
//            "LEFT JOIN FETCH w.wineType " +
//            "LEFT JOIN FETCH w.regions " +
//            "LEFT JOIN FETCH w.meals " +
//            "LEFT JOIN FETCH w.grapes " +
//            "WHERE w.id = :id")
//    @Fetch(FetchMode.SUBSELECT)
    @EntityGraph(attributePaths = {"images"})
    Optional<Wine> findByIdAndIsDeletedFalse(Long id);

    Page<Wine> findAllByIsDeletedFalse(Pageable pageable);
}
