package api.backwine.repository;

import api.backwine.model.WineImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineImageRepository extends JpaRepository<WineImage, Long> {
}
