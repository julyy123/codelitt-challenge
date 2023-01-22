package com.juliansanchez.codelittchallenge.repository;

import com.juliansanchez.codelittchallenge.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MemberRepository<T extends Member> extends JpaRepository<T, Long> {
}
