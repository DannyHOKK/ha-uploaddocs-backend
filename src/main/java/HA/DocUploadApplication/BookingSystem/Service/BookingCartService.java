package HA.DocUploadApplication.BookingSystem.Service;

import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.entity.BookingCart;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingCartService {


    BookingCart save(BookingCartDTO bookingCart);

    List<BookingCart> findBookingCartDetails(Long userId);

    String deleteByCartId(Integer cartId);

    List<BookingCart> getBooking(LocalDate date, LocalTime startTime, LocalTime endTime);
}
