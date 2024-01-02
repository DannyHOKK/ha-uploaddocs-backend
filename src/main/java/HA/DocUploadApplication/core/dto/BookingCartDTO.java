package HA.DocUploadApplication.core.dto;

import HA.DocUploadApplication.core.entity.BookingItem;
import HA.DocUploadApplication.core.entity.BookingTimeslot;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookingCartDTO {
    private Integer venueID;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT+8")
    private Date bookingDate;
    private BookingTimeslot timeslot;
    private BookingItem bookingItem;
    private String eventName;
    private String nature;
    private String extraCharge;
    private String venueUsage;
    private String Other;
    private String howToKnow;
    private Boolean foodOption;

    public BookingTimeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(BookingTimeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Boolean getFoodOption() {
        return foodOption;
    }

    public void setFoodOption(Boolean foodOption) {
        this.foodOption = foodOption;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }


    public BookingItem getBookingItem() {
        return bookingItem;
    }

    public void setBookingItem(BookingItem bookingItem) {
        this.bookingItem = bookingItem;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(String extraCharge) {
        this.extraCharge = extraCharge;
    }

    public String getVenueUsage() {
        return venueUsage;
    }

    public void setVenueUsage(String venueUsage) {
        this.venueUsage = venueUsage;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public String getHowToKnow() {
        return howToKnow;
    }

    public void setHowToKnow(String howToKnow) {
        this.howToKnow = howToKnow;
    }
}
