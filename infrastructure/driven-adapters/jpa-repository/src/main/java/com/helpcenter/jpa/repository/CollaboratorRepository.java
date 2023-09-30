package com.helpcenter.jpa.repository;

import com.helpcenter.jpa.entity.CollaboratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<CollaboratorEntity, Integer> {
}
