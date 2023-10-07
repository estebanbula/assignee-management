package com.helpcenter.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
public class BranchEntity extends AssigneeEntity {

    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
}
