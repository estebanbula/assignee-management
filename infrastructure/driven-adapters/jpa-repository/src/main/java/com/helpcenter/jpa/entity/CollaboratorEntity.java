package com.helpcenter.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "collaborator")
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorEntity extends WorkerEntity {

    @Column(name = "service_provide")
    private String serviceProvided;
    @Column(name = "retired_at")
    private Date retiredAt;
    @Column(name = "service_value")
    private Integer serviceValue;
    @Column(name = "currency")
    private String currency;
}
