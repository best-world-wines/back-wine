package api.backwine.repository;

import api.backwine.model.Grape;
import api.backwine.model.WineStyle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineStyleRepository extends SoftDeleteRepository<WineStyle, Long> {
}
