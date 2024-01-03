package HA.DocUploadApplication.BookingSystem.repository;

import HA.DocUploadApplication.core.entity.BookingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingCartRepository extends JpaRepository<BookingCart, Integer>, JpaSpecificationExecutor {
    @Query(value = "select * from booking_cart b where b.user_id = :userId", nativeQuery = true)
    List<BookingCart> findByUserId(Long userId);
}
