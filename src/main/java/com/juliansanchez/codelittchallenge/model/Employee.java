package com.juliansanchez.codelittchallenge.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Entity
public class Employee extends Member {

    private String role;
}
