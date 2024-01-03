package HA.DocUploadApplication.core.entity;

import HA.DocUploadApplication.core.entity.DocsMappingEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

@SqlResultSetMapping(name = "BookingCartMappingEntity", entities = {
        @EntityResult(entityClass = BookingCartMappingEntity.class ,
                fields = {
                        @FieldResult(name = "cartId" , column = "cart_id"),
                        @FieldResult(name = "userId" , column = "user_id"),
                        @FieldResult(name = "venueId" , column = "venue_id"),
                        @FieldResult(name = "bookingDate" , column = "booking_date"),
                        @FieldResult(name = "timeslotId" , column = "timeslot_id"),
                        @FieldResult(name = "bookingItemId" , column = "booking_item_id"),
                        @FieldResult(name = "eventName" , column = "event_name"),
                        @FieldResult(name = "nature" , column = "nature"),
                        @FieldResult(name = "extraCharge" , column = "extra_charge"),
                        @FieldResult(name = "venueUsage" , column = "venue_usage"),
                        @FieldResult(name = "other" , column = "other"),
                        @FieldResult(name = "howToKnow" , column = "how_to_know"),
                        @FieldResult(name = "foodOption" , column = "food_option")
                }
        )})
public class BookingCartMappingEntity {

    private Integer cartId;
    private Integer userId;
    private Integer venueId;
    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT+8")
    private Date bookingDate;
    private Integer timeslotId;
    private Integer bookingItemId;
    private String eventName;
    private String nature;
    private String extraCharge;
    private String venueUsage;
    private String other;
    private String howToKnow;
    private Boolean foodOption;


    public BookingCartMappingEntity() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Integer timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Integer getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(Integer bookingItemId) {
        this.bookingItemId = bookingItemId;
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

    public Boolean getFoodOption() {
        return foodOption;
    }

    public void setFoodOption(Boolean foodOption) {
        this.foodOption = foodOption;
    }
}
