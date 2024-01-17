//package HA.DocUploadApplication.core.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.time.LocalTime;
//import java.util.Date;
//
//@Entity
//@Table(name = "booking_timeslot")
//public class BookingTimeslot {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore
//    private Integer bookingTimeslotId;
//    private Date date;
//    private LocalTime startTime;
//    private LocalTime endTime;
//
//    public BookingTimeslot() {
//    }
//
//    public BookingTimeslot(Date date, LocalTime startTime, LocalTime endTime) {
//        this.date = date;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }
//
//    public Integer getBookingTimeslotId() {
//        return bookingTimeslotId;
//    }
//
//    public void setBookingTimeslotId(Integer bookingTimeslotId) {
//        this.bookingTimeslotId = bookingTimeslotId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(LocalTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(LocalTime endTime) {
//        this.endTime = endTime;
//    }
//}
