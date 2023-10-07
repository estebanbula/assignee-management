package com.helpcenter.assignee.gateway;

import com.helpcenter.assignee.model.Assignee;
import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;

import java.util.List;
import java.util.Optional;

public interface IAssignee {

    List<Collaborator> getAllCollaborators();
    List<Employee> getAllEmployees();
    List<Branch> getAllBranches();
    Worker addWorker(Worker worker);
    Branch addBranch(Branch branch);
    Collaborator addCollaborator(Collaborator collaborator);
    Employee addEmployee(Employee employee);
    //Optional<Assignee> assigneeById(String email);
}
