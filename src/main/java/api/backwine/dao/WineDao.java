package api.backwine.dao;

import api.backwine.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineDao extends JpaRepository<Wine, Long> {
}
