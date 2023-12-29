package com.example.WoofBackend_Develop.member.service;

import com.example.WoofBackend_Develop.member.model.Member;
import com.example.WoofBackend_Develop.member.repository.MemberRepo;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@Builder
public class MemberService {
    MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void signup(String email, String pw){
        memberRepo.save(Member.builder()
                .email(email)
                .PW(pw)
                .build());
    }

//    public void login(String email, String pw){
//        memberRepo.save(Member.builder()
//                        .email(email)
//                        .PW(pw)
//                .build());
//    }

    public void read(){

    }

    public void update(Member member){
        memberRepo.save(Member.builder()
                        .ID(member.getID())
                        .email(member.getEmail())
                        .phone_number(member.getPhone_number())
                        .social_securiitynumber(member.getSocial_securiitynumber())
                        .address(member.getAddress())
                .build());
    }

    public void delete(String ID){
        memberRepo.save(Member.builder()
                        .ID(ID)
                .build());
    }
}
