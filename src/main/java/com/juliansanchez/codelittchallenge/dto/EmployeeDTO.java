package com.juliansanchez.codelittchallenge.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EmployeeDTO extends MemberDTO {
    @NotBlank
    private String role;
}
