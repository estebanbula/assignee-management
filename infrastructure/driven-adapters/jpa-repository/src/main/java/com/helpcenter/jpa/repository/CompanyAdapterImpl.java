package com.helpcenter.jpa.repository;

import com.helpcenter.assignee.gateway.ICompany;
import com.helpcenter.assignee.model.Company;
import com.helpcenter.assignee.model.Worker;
import com.helpcenter.jpa.entity.CompanyEntity;
import com.helpcenter.jpa.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompanyAdapterImpl implements ICompany {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public Company saveCompany(Company company) {
        return Optional.of(companyRepository.save(modelMapper.map(company, CompanyEntity.class)))
                .map(savedCompany -> modelMapper.map(savedCompany, Company.class))
                .orElseThrow();
    }
}
