package com.example.WoofBackend_Develop.ceo.model.response;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateCeoRes {

    private Long id;
    private String name;
    private String image;
    private String address;
    private String type;
}
