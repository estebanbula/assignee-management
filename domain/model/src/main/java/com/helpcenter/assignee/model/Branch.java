package com.helpcenter.assignee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Branch extends Assignee {

    private String city;
    private String address;

    @Builder(builderMethodName = "branchAssigneeBuilder")
    public Branch(String assigneeId, String name, String city, String address) {
        super(assigneeId, name);
        this.city = city;
        this.address = address;
    }
}
