package com.juliansanchez.codelittchallenge.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Contractor extends Member{
    private int contractDuration;
}
