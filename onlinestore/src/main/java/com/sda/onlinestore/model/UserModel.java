package com.sda.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sda.onlinestore.common.utils.Hasher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userModel")
    private AddressModel addressModel;

    private String logo;
    private String channel;

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userModelList")
    private UserRole userRole;


     */
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnoreProperties("userModel")
    private List<OrderModel> orders; // -> un order format din mai multe orderline-uri , order = cart?

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }

    public UserModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.password = Hasher.encode(password);
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
/*
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

 */
}
