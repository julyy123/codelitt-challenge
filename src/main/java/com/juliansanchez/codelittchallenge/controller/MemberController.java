package com.juliansanchez.codelittchallenge.controller;

import com.juliansanchez.codelittchallenge.model.Member;
import com.juliansanchez.codelittchallenge.repository.MemberRepository;
import com.juliansanchez.codelittchallenge.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(final MemberService memberService) {

    }

    @GetMapping
    public ResponseEntity<Member> findMemberById(final Long id) {
        return ResponseEntity.ok(new Member());
    }
}
