package com.juliansanchez.codelittchallenge.mapper;

import com.juliansanchez.codelittchallenge.dto.ContractorDTO;
import com.juliansanchez.codelittchallenge.dto.EmployeeDTO;
import com.juliansanchez.codelittchallenge.dto.MemberDTO;
import com.juliansanchez.codelittchallenge.model.Contractor;
import com.juliansanchez.codelittchallenge.model.Employee;
import com.juliansanchez.codelittchallenge.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;

@Mapper(componentModel="spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface MemberMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currency", ignore = true)
    @SubclassMapping( source = ContractorDTO.class, target = Contractor.class )
    @SubclassMapping( source = EmployeeDTO.class, target = Employee.class )
    Member toMember(final MemberDTO memberDTO);
}
