package com.helpcenter.jpa.repository;

import com.helpcenter.jpa.entity.SimpleAssignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SimpleAssigneeRepository extends JpaRepository<SimpleAssignee, Integer> {

    @Query(value = "select asg.assignee_id, asg.name as full_name, asg.email as email, " +
            "co.name as company, asg.city as city, asg.address as address " +
            "from Assignee asg " +
            "inner join company co on co.company_id = asg.company_id " +
            "where assignee_id = :id", nativeQuery = true)
    SimpleAssignee findByAssigneeId(@Param("id") Integer id);
}
