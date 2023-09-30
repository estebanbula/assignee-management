package com.helpcenter.assignee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Employee extends Worker {

    private String contract;
    private String rol;
    private String companyEmail;
    private Integer salary;

    @Builder(builderMethodName = "employeeAssigneeBuilder")
    public Employee(String assigneeId, String name, String email, String documentType, Integer documentNumber, Company company, String contract, String rol, String companyEmail, Integer salary) {
        super(assigneeId, name, email, documentType, documentNumber, company);
        this.contract = contract;
        this.rol = rol;
        this.companyEmail = companyEmail;
        this.salary = salary;
    }
}
