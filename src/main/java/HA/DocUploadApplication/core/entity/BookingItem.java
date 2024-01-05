package HA.DocUploadApplication.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingItemId;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    private Integer item7;
    private Integer item8;
    private Integer item9;
    private Integer item10;
    private Integer item11;
    private Integer item12;
    private Integer item13;

    public BookingItem() {
    }

    public BookingItem(Integer item1, Integer item2, Integer item3, Integer item4, Integer item5, Integer item6, Integer item7, Integer item8, Integer item9, Integer item10, Integer item11, Integer item12, Integer item13) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.item7 = item7;
        this.item8 = item8;
        this.item9 = item9;
        this.item10 = item10;
        this.item11 = item11;
        this.item12 = item12;
        this.item13 = item13;
    }

    public Integer getBookingItemId() {
        return bookingItemId;
    }

    public void setBookingItemId(Integer bookingItemId) {
        this.bookingItemId = bookingItemId;
    }

    public Integer getItem1() {
        return item1;
    }

    public void setItem1(Integer item1) {
        this.item1 = item1;
    }

    public Integer getItem2() {
        return item2;
    }

    public void setItem2(Integer item2) {
        this.item2 = item2;
    }

    public Integer getItem3() {
        return item3;
    }

    public void setItem3(Integer item3) {
        this.item3 = item3;
    }

    public Integer getItem4() {
        return item4;
    }

    public void setItem4(Integer item4) {
        this.item4 = item4;
    }

    public Integer getItem5() {
        return item5;
    }

    public void setItem5(Integer item5) {
        this.item5 = item5;
    }

    public Integer getItem6() {
        return item6;
    }

    public void setItem6(Integer item6) {
        this.item6 = item6;
    }

    public Integer getItem7() {
        return item7;
    }

    public void setItem7(Integer item7) {
        this.item7 = item7;
    }

    public Integer getItem8() {
        return item8;
    }

    public void setItem8(Integer item8) {
        this.item8 = item8;
    }

    public Integer getItem9() {
        return item9;
    }

    public void setItem9(Integer item9) {
        this.item9 = item9;
    }

    public Integer getItem10() {
        return item10;
    }

    public void setItem10(Integer item10) {
        this.item10 = item10;
    }

    public Integer getItem11() {
        return item11;
    }

    public void setItem11(Integer item11) {
        this.item11 = item11;
    }

    public Integer getItem12() {
        return item12;
    }

    public void setItem12(Integer item12) {
        this.item12 = item12;
    }

    public Integer getItem13() {
        return item13;
    }

    public void setItem13(Integer item13) {
        this.item13 = item13;
    }
}
