package api.backwine.repository;

import api.backwine.model.WineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends JpaRepository<WineType, Long> {
}
