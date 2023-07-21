package api.backwine.repository;

import api.backwine.model.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends SoftDeleteRepository<Country, String> {
    Optional<Country> findByIdAndIsDeletedFalse(String id);

    List<Country> findAllByIsDeletedFalse();
}
