package com.example.WoofBackend_Develop.ceo.model.request;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostCreateCeoReq {

    private String email;
    private String password;
    private String name;
    private MultipartFile image;
    private String business_license;
    private String phone_number;
    private String address;
    private String type;
}
