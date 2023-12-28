package HA.DocUploadApplication.BookingSystem.Service.Impl;

import HA.DocUploadApplication.BookingSystem.Service.BookingCartService;
import HA.DocUploadApplication.BookingSystem.repository.BookingCartRepository;
import HA.DocUploadApplication.core.entity.BookingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingCartServiceImpl implements BookingCartService {

    @Autowired
    private BookingCartRepository bookingCartRepository;


    @Override
    public void save(BookingCart bookingCart) {
        bookingCartRepository.save(bookingCart);
    }
}
