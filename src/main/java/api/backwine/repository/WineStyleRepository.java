package api.backwine.repository;

import api.backwine.model.WineStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineStyleRepository extends JpaRepository<WineStyle, Long> {
}
