package HA.DocUploadApplication.BookingSystem.repository;

import HA.DocUploadApplication.core.entity.VenueInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueInfoRepository extends JpaRepository<VenueInfo, Integer>, JpaSpecificationExecutor {
}
