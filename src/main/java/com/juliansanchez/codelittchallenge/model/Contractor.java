package com.juliansanchez.codelittchallenge.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(Contractor.DISCRIMINATOR_VALUE)
@Entity
public class Contractor extends Member {
    public static final String DISCRIMINATOR_VALUE = "CONTRACTOR";

    private int contractDuration;
}
