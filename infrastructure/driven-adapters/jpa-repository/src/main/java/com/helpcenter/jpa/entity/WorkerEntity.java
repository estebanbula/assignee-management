package com.helpcenter.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WorkerEntity extends AssigneeEntity {

    @Column(name = "email")
    private String email;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "document_number")
    private Integer documentNumber;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
}
