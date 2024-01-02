package HA.DocUploadApplication.BookingSystem.Service;

import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.entity.BookingCart;

public interface BookingCartService {


    BookingCart save(BookingCartDTO bookingCart);
}
