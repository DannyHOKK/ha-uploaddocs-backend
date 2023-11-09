package HA.DocUploadApplication.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
public class UserDetailsInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String mobile;
    private String position;
    @Lob
    @JsonIgnore
    private Blob icon;
    private Date createDt;
    private Date lastModifyDt;

    public UserDetailsInfo() {
    }

    public UserDetailsInfo(String address, String mobile, String position, Blob icon, Date createDt, Date lastModifyDt) {
        this.address = address;
        this.mobile = mobile;
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

    public Blob getIcon() {
        return icon;
    }

    public void setIcon(Blob icon) {
        this.icon = icon;
    }

    public UserDetailsInfo(String address, String mobile, String position) {
        this.address = address;
        this.mobile = mobile;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
