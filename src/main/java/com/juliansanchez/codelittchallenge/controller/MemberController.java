package com.juliansanchez.codelittchallenge.controller;

import com.juliansanchez.codelittchallenge.dto.EmployeeDTO;
import com.juliansanchez.codelittchallenge.dto.MemberDTO;
import com.juliansanchez.codelittchallenge.mapper.MemberMapper;
import com.juliansanchez.codelittchallenge.model.Employee;
import com.juliansanchez.codelittchallenge.model.Member;
import com.juliansanchez.codelittchallenge.service.MemberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("members")
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(final MemberService memberService, final MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public ResponseEntity<List<Member>> findAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable("id")final Long id) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@Valid @RequestBody final MemberDTO memberDTO) {
        final Member createdMember = memberService.createMember(memberMapper.toMember(memberDTO));

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdMember.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") final Long id,
                                               @Valid @RequestBody final MemberDTO memberDTO) {
        memberService.updateMember(id, memberMapper.toMember(memberDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable final Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
