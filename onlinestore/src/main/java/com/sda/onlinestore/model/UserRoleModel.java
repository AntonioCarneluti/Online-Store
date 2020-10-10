package com.sda.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UserRoles")
public class UserRoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userRoleModel", orphanRemoval = false)
    @JsonIgnoreProperties("userRoleModel")
    private List<UserModel> userModel;

    public UserRoleModel() {
    }

}
