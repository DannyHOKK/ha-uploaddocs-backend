package HA.DocUploadApplication.User.repository;

import HA.DocUploadApplication.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByEmail(String email);

    @Query(value = "select name from user u where u.name = :checkName",nativeQuery = true)
    String checkExitName(@Param("checkName") String name);

    @Query(value = "select username from user u where u.username = :checkUserName",nativeQuery = true)
    String checkExitUserName(@Param("checkUserName") String username);

    @Query(value = "select email from user u where u.email = :checkEmail",nativeQuery = true)
    String checkEmail(@Param("checkEmail") String email);
}
