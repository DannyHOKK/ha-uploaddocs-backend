package HA.DocUploadApplication.core.dto;

import java.sql.Blob;

public class UserInfoDTO {
    private Long id;
    private String username;
    private String email;
    private String mobile;
    private String address;
    private String position;
    private Blob icon;

    public UserInfoDTO() {
    }

    public UserInfoDTO(String username, String email, String mobile, String address, String position, Blob icon) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.position = position;
        this.icon = icon;
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
