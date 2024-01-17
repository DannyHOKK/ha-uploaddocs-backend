package HA.DocUploadApplication.BookingSystem.repository;

import HA.DocUploadApplication.core.entity.BookingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingCartRepository extends JpaRepository<BookingCart, Integer>, JpaSpecificationExecutor {
    @Query(value = "select * from booking_cart b where b.user_id = :userId", nativeQuery = true)
    List<BookingCart> findByUserId(Long userId);
    @Query(value = "select * from booking_cart b where b.booking_date = :bookingDate and :startTime <= b.start_time and :endTime >= b.end_time", nativeQuery = true)
    List<BookingCart> findByBookingDateAndStartTimeLessThanAndEndTimeGreaterThan(LocalDate bookingDate, LocalTime startTime, LocalTime endTime);

    @Query("SELECT b FROM BookingCart b WHERE b.bookingDate = :bookingDate AND :endTime > b.startTime AND :startTime < b.endTime")
    List<BookingCart> findConflictingSlots(@Param("bookingDate") LocalDate bookingDate,@Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);
}
