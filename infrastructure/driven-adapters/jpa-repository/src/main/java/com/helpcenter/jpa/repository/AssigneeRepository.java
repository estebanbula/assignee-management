package com.helpcenter.jpa.repository;

import com.helpcenter.jpa.entity.AssigneeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneeRepository extends JpaRepository<AssigneeEntity, Integer> {
}
