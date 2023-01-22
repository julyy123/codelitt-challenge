package com.juliansanchez.codelittchallenge.service;


import com.juliansanchez.codelittchallenge.model.Employee;
import com.juliansanchez.codelittchallenge.model.Member;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MemberService {
    private final ContractorService contractorService;
    private final EmployeeService employeeService;

    public MemberService(final ContractorService contractorService,
                         final EmployeeService employeeService) {
        this.contractorService = contractorService;
        this.employeeService = employeeService;
    }

    public List<Member> findAll() {
        new Employee().
        final List<Employee> employees = List.of(
                Employee.builder().id(1L).fullName("Lionel Messi")
                        .annualSalary(BigDecimal.TEN).tags(Set.of("C#", "Java"))
                new Employee(1L, "Lionel Messi", 1000, Set.of("C#", "Java"), "Software Engineer")
                );
        final List<Member> memberList = new ArrayList<>(employeeService.findAll());

        memberList.addAll(contractorService.findAll());

        return memberList;
    }
}
