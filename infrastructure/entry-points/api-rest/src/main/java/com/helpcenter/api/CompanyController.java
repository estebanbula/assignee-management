package com.helpcenter.api;

import com.helpcenter.assignee.model.Company;
import com.helpcenter.usecase.CompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/company", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyUseCase companyUseCase;

    @PostMapping("")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyUseCase.createCompany(company), HttpStatus.CREATED);
    }

}
