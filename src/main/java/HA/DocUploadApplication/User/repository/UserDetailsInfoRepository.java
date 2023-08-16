package HA.DocUploadApplication.User.repository;

import HA.DocUploadApplication.core.entity.UserDetailsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsInfoRepository extends JpaRepository<UserDetailsInfo, Long> {
}
