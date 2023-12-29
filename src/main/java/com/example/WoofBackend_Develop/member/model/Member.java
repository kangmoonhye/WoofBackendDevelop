package com.example.WoofBackend_Develop.member.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;

    private String PW;
    private String email;
    private String social_securiitynumber;
    private String phone_number;
    private String address;
}
