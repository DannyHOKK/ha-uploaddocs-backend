package HA.DocUploadApplication.BookingSystem.Service;

import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.entity.BookingCart;

import java.util.List;

public interface BookingCartService {


    BookingCart save(BookingCartDTO bookingCart);

    List<BookingCart> findBookingCartDetails(Long userId);
}
