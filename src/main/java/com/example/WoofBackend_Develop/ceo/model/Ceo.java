package com.example.WoofBackend_Develop.ceo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ceo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 20, unique = true)
    private String business_license;
    @Column(nullable = false, length = 20, unique = true)
    private String phone_number;
    @Column(length = 80)
    private String address;
    @Column(length = 30)
    private String type;
    @Column(length = 30)
    private String name;
    @Column(length = 200, unique = true)
    private String image;

}
