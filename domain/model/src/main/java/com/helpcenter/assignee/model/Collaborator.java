package com.helpcenter.assignee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator extends Worker {

    private String serviceProvided;
    private Date retiredAt;
    private Integer serviceValue;
    private String currency;

    @Builder(builderMethodName = "collaboratorAssigneeBuilder")
    public Collaborator(String assigneeId, String name, String email, String documentType, Integer documentNumber, Company company, String serviceProvider, Date retiredAt, Integer serviceValue, String currency) {
        super(assigneeId, name, email, documentType, documentNumber, company);
        this.serviceProvided = serviceProvider;
        this.retiredAt = retiredAt;
        this.serviceValue = serviceValue;
        this.currency = currency;
    }
}
