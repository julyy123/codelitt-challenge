package com.juliansanchez.codelittchallenge.service;


import com.juliansanchez.codelittchallenge.exception.MemberNotFoundException;
import com.juliansanchez.codelittchallenge.exception.MemberTypeChangeException;
import com.juliansanchez.codelittchallenge.model.Contractor;
import com.juliansanchez.codelittchallenge.model.Employee;
import com.juliansanchez.codelittchallenge.model.Member;
import com.juliansanchez.codelittchallenge.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final CountryAPIService countryAPIService;

    public MemberService(final MemberRepository memberRepository, final CountryAPIService countryAPIService) {
        this.memberRepository = memberRepository;
        this.countryAPIService = countryAPIService;
    }

    public Optional<Member> findById(final Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member createMember(final Member member) {
        member.setCurrency(countryAPIService.getCountryCurrency(member.getCountry()));
        return memberRepository.save(member);
    }

    public Member updateMember(final Long id, final Member member) {
        final Optional<Member> existingMemberOpt = memberRepository.findById(id);
        final Member existingMember = existingMemberOpt.orElseThrow(MemberNotFoundException::new);

        if (!existingMember.getMemberType().equals(member.getMemberType())) {
            throw new MemberTypeChangeException();
        }

        member.setId(id);
        if (!existingMember.getCountry().equals(member.getCountry())) {
            member.setCurrency(countryAPIService.getCountryCurrency(member.getCountry()));
        }

        return memberRepository.save(member);
    }

    public void deleteById(final Long id) {
        memberRepository.deleteById(id);
    }
}
