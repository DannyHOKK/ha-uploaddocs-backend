package HA.DocUploadApplication.core.dto;

import HA.DocUploadApplication.core.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Lob;
import java.sql.Blob;
import java.util.Date;

public class UserInfoDTO {
    private Long id;
    private String username;
    private String email;
    private String mobile;
    private String address;
    private String position;
    @JsonIgnore
    @Lob
    private Blob icon;
    private Date createDt;
    private Date lastModifyDt;

    public UserInfoDTO() {
    }

    public UserInfoDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.mobile = user.getUserDetailsInfo().getMobile();
        this.address = user.getUserDetailsInfo().getAddress();
        this.position = user.getUserDetailsInfo().getPosition();
        this.icon = user.getUserDetailsInfo().getIcon();
        this.createDt = user.getUserDetailsInfo().getCreateDt();
        this.lastModifyDt = user.getUserDetailsInfo().getLastModifyDt();
    }

    public UserInfoDTO(String username, String email, String mobile, String address, String position, Blob icon, Date createDt, Date lastModifyDt) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.position = position;
        this.icon = icon;
        this.createDt = createDt;
        this.lastModifyDt = lastModifyDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getLastModifyDt() {
        return lastModifyDt;
    }

    public void setLastModifyDt(Date lastModifyDt) {
        this.lastModifyDt = lastModifyDt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Blob getIcon() {
        return icon;
    }

    public void setIcon(Blob icon) {
        this.icon = icon;
    }
}
