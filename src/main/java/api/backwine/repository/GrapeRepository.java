package api.backwine.repository;

import api.backwine.model.Country;
import api.backwine.model.Grape;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapeRepository extends SoftDeleteRepository<Grape, Long> {
}
