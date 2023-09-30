package com.helpcenter.usecase;

import com.helpcenter.assignee.gateway.ICompany;
import com.helpcenter.assignee.model.Company;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompanyUseCase {

    private final ICompany companyRepository;

    public Company createCompany(Company company) {
        return companyRepository.saveCompany(company);
    }
}
