package com.sda.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private AdressModel adressModel;
    private String logo;
    private String channel;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userList")
    private UserRoleModel userRoleModel;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AdressModel getAdressModel() {
        return adressModel;
    }

    public void setAdressModel(AdressModel adressModel) {
        this.adressModel = adressModel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
