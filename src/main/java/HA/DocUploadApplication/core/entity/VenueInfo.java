package HA.DocUploadApplication.core.entity;

import HA.DocUploadApplication.core.dto.VenueInfoDTO;

import javax.persistence.*;

@Entity
public class VenueInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String venueName;
    private String venueCategory;
    private String nop;
    private String area;
    @Lob
    @Column(length = 100000000)
    private byte[] photo;

    public VenueInfo() {
    }

    public VenueInfo(VenueInfoDTO venueInfoDTO){
        this.venueName = venueInfoDTO.getVenueName();
        this.area = venueInfoDTO.getArea();
        this.nop = venueInfoDTO.getNop();
        this.venueCategory = venueInfoDTO.getVenueCategory();
    }


    public VenueInfo(String venueName, String nop, String area, String venueCategory,byte[] photo) {
        this.venueName = venueName;
        this.venueCategory = venueCategory;
        this.nop = nop;
        this.area = area;
        this.photo = photo;
    }

    public String getVenueCategory() {
        return venueCategory;
    }

    public void setVenueCategory(String venueCategory) {
        this.venueCategory = venueCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
