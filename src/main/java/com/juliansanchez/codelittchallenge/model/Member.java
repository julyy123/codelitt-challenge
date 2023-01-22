package com.juliansanchez.codelittchallenge.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@MappedSuperclass
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String fullName;

    protected BigDecimal annualSalary;

    @ElementCollection
    protected Set<String> tags;
}
