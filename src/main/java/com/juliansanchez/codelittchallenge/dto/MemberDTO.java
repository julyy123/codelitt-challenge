package com.juliansanchez.codelittchallenge.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.juliansanchez.codelittchallenge.model.Contractor;
import com.juliansanchez.codelittchallenge.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "memberType",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmployeeDTO.class, name = Employee.DISCRIMINATOR_VALUE),
        @JsonSubTypes.Type(value = ContractorDTO.class, name = Contractor.DISCRIMINATOR_VALUE)
})
@Data
@NoArgsConstructor
public abstract class MemberDTO {
    @NotBlank
    protected String memberType;

    @NotBlank
    protected String fullName;

    @NotNull
    protected BigDecimal annualSalary;

    @NotEmpty
    protected Set<@NotBlank String> tags;

    @NotBlank
    protected String country;
}
