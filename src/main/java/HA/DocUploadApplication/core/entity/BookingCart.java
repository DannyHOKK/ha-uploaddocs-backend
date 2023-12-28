package HA.DocUploadApplication.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_cart")
public class BookingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venue_id")
    private VenueInfo venueInfo;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT+8")
    private Date bookingDate;
    private String timeslot;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss",timezone = "GMT+8")
    private Date createDt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_item_id")
    private BookingItem bookingItem;
    private String eventName;
    private String nature;
    private String extraCharge;
    private String venueUsage;
    private String Other;
    private String howToKnow;

    public BookingCart(User user, VenueInfo venueInfo, Date bookingDate, String timeslot, Date createDt, BookingItem bookingItem, String eventName, String nature, String extraCharge, String venueUsage, String other, String howToKnow) {
        this.user = user;
        this.venueInfo = venueInfo;
        this.bookingDate = bookingDate;
        this.timeslot = timeslot;
        this.createDt = createDt;
        this.bookingItem = bookingItem;
        this.eventName = eventName;
        this.nature = nature;
        this.extraCharge = extraCharge;
        this.venueUsage = venueUsage;
        Other = other;
        this.howToKnow = howToKnow;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VenueInfo getVenueInfo() {
        return venueInfo;
    }

    public void setVenueInfo(VenueInfo venueInfo) {
        this.venueInfo = venueInfo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
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


