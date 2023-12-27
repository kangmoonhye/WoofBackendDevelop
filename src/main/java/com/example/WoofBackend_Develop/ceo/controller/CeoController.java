package com.example.WoofBackend_Develop.ceo.controller;


import com.example.WoofBackend_Develop.ceo.model.request.PostCreateCeoReq;
import com.example.WoofBackend_Develop.ceo.model.response.PostCreateCeoRes;
import com.example.WoofBackend_Develop.ceo.service.CeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ceo")
public class CeoController {

    private CeoService ceoService;



    public CeoController(CeoService ceoService) {
        this.ceoService = ceoService;

    }


    // 회원가입 완성
    @RequestMapping(method =  RequestMethod.POST, value = "/signup")
    public ResponseEntity create(PostCreateCeoReq request){
        PostCreateCeoRes response = ceoService.create(request);
        return ResponseEntity.ok().body(response);
    }


}


