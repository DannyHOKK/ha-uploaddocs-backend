package HA.DocUploadApplication.BookingSystem.repository;

import HA.DocUploadApplication.core.entity.BookingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCartRepository extends JpaRepository<BookingCart, Integer> {
}
