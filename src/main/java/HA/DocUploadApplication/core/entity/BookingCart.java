package HA.DocUploadApplication.core.entity;

import HA.DocUploadApplication.core.dto.BookingCartDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_cart")
public class BookingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "venue_id")
    private VenueInfo venueInfo;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT+8")
    private Date bookingDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeslot_id")
    private BookingTimeslot timeslot;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss",timezone = "GMT+8")
    private Date createDt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_item_id")
    private BookingItem bookingItem;
    private String eventName;
    private String nature;
    private String extraCharge;
    private String venueUsage;
    private String other;
    private String howToKnow;
    private Boolean foodOption;

    public BookingCart() {
    }
    public BookingCart(BookingCartDTO bookingCartDTO){
        this.bookingDate = bookingCartDTO.getBookingDate();
        this.timeslot = bookingCartDTO.getTimeslot();
        this.bookingItem = bookingCartDTO.getBookingItem();
        this.eventName = bookingCartDTO.getEventName();
        this.nature = bookingCartDTO.getNature();
        this.extraCharge = bookingCartDTO.getExtraCharge();
        this.venueUsage = bookingCartDTO.getVenueUsage();
        this.other = bookingCartDTO.getOther();
        this.howToKnow = bookingCartDTO.getHowToKnow();
        this.foodOption = bookingCartDTO.getFoodOption();
    }

    public BookingCart(Integer cartId, User user, VenueInfo venueInfo, Date bookingDate, BookingTimeslot timeslot, Date createDt, BookingItem bookingItem, String eventName, String nature, String extraCharge, String venueUsage, String other, String howToKnow, Boolean foodOption) {
        this.cartId = cartId;
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
        this.other = other;
        this.howToKnow = howToKnow;
        this.foodOption = foodOption;
    }

    public Boolean getFoodOption() {
        return foodOption;
    }

    public void setFoodOption(Boolean foodOption) {
        this.foodOption = foodOption;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
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

    public BookingTimeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(BookingTimeslot timeslot) {
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
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getHowToKnow() {
        return howToKnow;
    }

    public void setHowToKnow(String howToKnow) {
        this.howToKnow = howToKnow;
    }
}


