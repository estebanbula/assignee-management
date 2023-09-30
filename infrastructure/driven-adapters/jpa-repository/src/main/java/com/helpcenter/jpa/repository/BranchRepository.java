package com.helpcenter.jpa.repository;

import com.helpcenter.jpa.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
}
