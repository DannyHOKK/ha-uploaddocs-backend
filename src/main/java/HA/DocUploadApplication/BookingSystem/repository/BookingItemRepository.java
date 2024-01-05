package HA.DocUploadApplication.BookingSystem.repository;

import HA.DocUploadApplication.core.entity.BookingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingItemRepository extends JpaRepository<BookingItem, Integer> {
}
