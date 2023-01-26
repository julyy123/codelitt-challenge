package com.juliansanchez.codelittchallenge.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(Employee.DISCRIMINATOR_VALUE)
@Entity
public class Employee extends Member {
    public static final String DISCRIMINATOR_VALUE = "EMPLOYEE";

    private String role;
}
