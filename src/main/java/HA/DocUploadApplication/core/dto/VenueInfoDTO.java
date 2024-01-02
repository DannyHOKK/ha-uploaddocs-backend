package HA.DocUploadApplication.core.dto;

public class VenueInfoDTO {

    private String venueName;
    private String venueCategory;
    private String nop;
    private String area;

    public String getVenueName() {
        return venueName;
    }

    public VenueInfoDTO(String venueName, String venueCategory, String nop, String area) {
        this.venueName = venueName;
        this.venueCategory = venueCategory;
        this.nop = nop;
        this.area = area;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueCategory() {
        return venueCategory;
    }

    public void setVenueCategory(String venueCategory) {
        this.venueCategory = venueCategory;
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
}
