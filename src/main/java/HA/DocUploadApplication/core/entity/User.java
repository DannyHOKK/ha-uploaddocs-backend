package HA.DocUploadApplication.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users",    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") }
)
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;
    @Email
    @NotNull
    private String email;

    @JsonIgnore
    @NotNull
    @Size(min = 8)
    private String password;
    @NotNull
    private String roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    private UserDetailsInfo userDetailsInfo;

    public User() {
    }

    public User(String username, String email, String password, String roles, UserDetailsInfo userDetailsInfo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.userDetailsInfo = userDetailsInfo;
    }

    public UserDetailsInfo getUserDetailsInfo() {
        return userDetailsInfo;
    }

    public void setUserDetailsInfo(UserDetailsInfo userDetailsInfo) {
        this.userDetailsInfo = userDetailsInfo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
