package HA.DocUploadApplication.User.repository;

import HA.DocUploadApplication.core.entity.UserDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserDetailsInfoRepository extends JpaRepository<UserDetailsInfo, Long> {
}
