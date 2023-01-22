package com.juliansanchez.codelittchallenge.service;

import com.juliansanchez.codelittchallenge.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {
    private final ContractorService contractorService;

    public ContractorService(final ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    public List<Employee> findAll() {
        return contractorService.findAll();
    }
}
