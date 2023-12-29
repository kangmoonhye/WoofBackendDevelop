package com.example.WoofBackend_Develop.member.repository;

import com.example.WoofBackend_Develop.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, String > {
}
