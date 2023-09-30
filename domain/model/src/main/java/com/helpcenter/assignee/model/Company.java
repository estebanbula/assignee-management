package com.helpcenter.assignee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private Integer companyId;
    private String name;
    private String nit;
    private String location;
}
