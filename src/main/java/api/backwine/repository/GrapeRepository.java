package api.backwine.repository;

import api.backwine.model.Grape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends JpaRepository<Grape, Long> {
}
