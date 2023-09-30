package com.helpcenter.assignee.gateway;

import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;

import java.util.List;

public interface IAssignee {

    List<Collaborator> getAllCollaborators();
    List<Employee> getAllEmployees();
    List<Branch> getAllBranches();
    Worker addWorker(Worker worker);
    Branch addBranch(Branch branch);
    Collaborator addCollaborator(Collaborator collaborator);
    Employee addEmployee(Employee employee);
}
