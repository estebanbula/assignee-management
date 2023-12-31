package com.helpcenter.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity extends WorkerEntity {

    @Column(name = "contract")
    private String contract;
    @Column(name = "rol")
    private String rol;
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "salary")
    private Integer salary;
}
