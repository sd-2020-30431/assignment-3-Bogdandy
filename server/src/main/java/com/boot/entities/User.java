package com.boot.entities;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="userdata")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name="Email")
    private String email;

    @Column(name = "Phone")
    private String phone;
}