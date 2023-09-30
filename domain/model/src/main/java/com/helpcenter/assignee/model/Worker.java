package com.helpcenter.assignee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Worker extends Assignee {

    private String email;
    private String documentType;
    private Integer documentNumber;
    private Company company;

    @Builder(builderMethodName = "workerAssigneeBuilder")
    public Worker(String assigneeId, String name, String email, String documentType, Integer documentNumber, Company company) {
        super(assigneeId, name);
        this.email = email;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.company = company;
    }
}
