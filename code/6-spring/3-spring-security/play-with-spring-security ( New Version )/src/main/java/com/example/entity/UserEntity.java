package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles",joinColumns = {@JoinColumn(name = "user_id")})
    private List<String> authorities;


}
