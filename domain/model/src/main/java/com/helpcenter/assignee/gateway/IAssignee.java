package com.helpcenter.assignee.gateway;

import com.helpcenter.assignee.model.Assignee;
import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;
import com.helpcenter.assignee.response.SimpleAssigneeResponse;

import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

public interface IAssignee {

    List<Collaborator> getAllCollaborators();
    List<Employee> getAllEmployees();
    List<Branch> getAllBranches();
    Worker addWorker(Worker worker);
    Branch addBranch(Branch branch);
    Collaborator addCollaborator(Collaborator collaborator);
    Employee addEmployee(Employee employee);
    Optional<SimpleAssigneeResponse> assigneeById(Integer id);
}
