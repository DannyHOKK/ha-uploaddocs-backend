package HA.DocUploadApplication.core.dao;

import HA.DocUploadApplication.core.entity.BookingCart;

import java.time.LocalDate;
import java.time.LocalTime;

public class UnavailableTimeslot {

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public UnavailableTimeslot(BookingCart bookingCart) {
        this.bookingDate = bookingCart.getBookingDate();
        this.startTime = bookingCart.getStartTime();
        this.endTime = bookingCart.getEndTime();
    }

    public UnavailableTimeslot(LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
