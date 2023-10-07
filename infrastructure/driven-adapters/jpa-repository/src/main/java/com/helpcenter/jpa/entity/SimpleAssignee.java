package com.helpcenter.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SimpleAssignee {

    @Id
    private Integer assigneeId;
    private String fullName;
    private String email;
    private String company;
    private String city;
    private String address;
}
