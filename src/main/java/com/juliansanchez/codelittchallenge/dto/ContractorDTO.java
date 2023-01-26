package com.juliansanchez.codelittchallenge.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ContractorDTO extends MemberDTO {
    @NotNull
    private int contractDuration;
}
