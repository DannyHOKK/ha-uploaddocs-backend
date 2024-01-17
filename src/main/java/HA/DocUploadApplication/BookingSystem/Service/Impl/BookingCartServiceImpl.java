package HA.DocUploadApplication.BookingSystem.Service.Impl;

import HA.DocUploadApplication.BookingSystem.Service.BookingCartService;
import HA.DocUploadApplication.BookingSystem.repository.BookingCartRepository;
import HA.DocUploadApplication.BookingSystem.repository.VenueInfoRepository;
import HA.DocUploadApplication.User.repository.UserRepository;
import HA.DocUploadApplication.core.dto.BookingCartDTO;
import HA.DocUploadApplication.core.entity.BookingCart;
import HA.DocUploadApplication.core.entity.User;
import HA.DocUploadApplication.core.entity.VenueInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class BookingCartServiceImpl implements BookingCartService {

    @Autowired
    private BookingCartRepository bookingCartRepository;
    @Autowired
    private VenueInfoRepository venueInfoRepository;
    @Autowired
    private UserRepository userRepository;


//    public boolean isAvailable(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
//        List<BookingCart> matchingReservations = bookingCartRepository.findByBookingDateAndStartTimeLessThanAndEndTimeGreaterThan(bookingDate, endTime, startTime);
//        return matchingReservations.isEmpty();
//    }
    private boolean isTimeSlotBooked(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        List<BookingCart> conflictingSlots = bookingCartRepository.findConflictingSlots(bookingDate, startTime, endTime);
        return !conflictingSlots.isEmpty();
    }


    @Override
    public BookingCart save(BookingCartDTO bookingCartDto) {

        try {
            if (isTimeSlotBooked(bookingCartDto.getBookingDate(),bookingCartDto.getStartTime(),bookingCartDto.getEndTime())){
                return null;
            }

            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            VenueInfo venueInfo = venueInfoRepository.findById(bookingCartDto.getVenueID()).orElseThrow();
            User user = userRepository.findAllByUsername(userDetails.getUsername()).orElseThrow();

            BookingCart bookingCart = new BookingCart(bookingCartDto);
            bookingCart.setUser(user);
            bookingCart.setVenueInfo(venueInfo);
            bookingCart.setCreateDt(new Date());

            bookingCartRepository.save(bookingCart);
            return bookingCart;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<BookingCart> findBookingCartDetails(Long userId) {

        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<BookingCart> bookingCartList = bookingCartRepository.findByUserId(userId);
            return bookingCartList;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String deleteByCartId(Integer cartId) {

        try {
            bookingCartRepository.deleteById(cartId);
            return "";
        }catch (Exception e){
            return "Delete error";
        }
    }

    @Override
    public List<BookingCart> getBooking(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        return bookingCartRepository.findByBookingDateAndStartTimeLessThanAndEndTimeGreaterThan(bookingDate,startTime,endTime);
    }
}
