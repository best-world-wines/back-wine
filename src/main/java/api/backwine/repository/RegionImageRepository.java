package api.backwine.repository;

import api.backwine.model.RegionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionImageRepository extends JpaRepository<RegionImage, Long> {
}
