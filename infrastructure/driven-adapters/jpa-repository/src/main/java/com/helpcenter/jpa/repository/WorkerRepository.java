package com.helpcenter.jpa.repository;

import com.helpcenter.jpa.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Integer> {
}
