package com.example.WoofBackend_Develop.member.controller;

import com.example.WoofBackend_Develop.member.model.Member;
import com.example.WoofBackend_Develop.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
//    리뷰컨틀롤러 만들어야됨
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(String email, String pw){
        memberService.signup(email, pw);

        return ResponseEntity.ok().body("회원가입을 축하드립니다");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(String email, String pw){
        memberService.login(email,pw);

        return ResponseEntity.ok().body("로그인 성공");
//        if(memberService.login()==false){
//            return ResponseEntity.ok().body("로그인 실패");
//        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(String ID){
        return ResponseEntity.ok().body("");
    }


    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(Member member){
        memberService.update(member);
        return ResponseEntity.ok().body("수정");
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(String ID){
        memberService.delete(ID);
        return ResponseEntity.ok().body("삭제");
    }



}
