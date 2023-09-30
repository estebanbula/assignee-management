package com.helpcenter.usecase;

import com.helpcenter.assignee.gateway.IAssignee;
import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;
import com.helpcenter.assignee.response.AssigneesResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AssigneeUseCase {

    private final IAssignee assigneeRepository;

    public Worker addWorker(Worker worker) {
        return assigneeRepository.addWorker(worker);
    }

    public Branch addBranch(Branch branch) {
        return assigneeRepository.addBranch(branch);
    }

    public Employee addEmployee(Employee employee) {
        return assigneeRepository.addEmployee(employee);
    }

    public Collaborator addCollaborator(Collaborator collaborator) {
        return assigneeRepository.addCollaborator(collaborator);
    }

    public AssigneesResponse retrieveAssignees() {
        List<Collaborator> collaborators = assigneeRepository.getAllCollaborators();
        List<Employee> employees = assigneeRepository.getAllEmployees();
        List<Branch> branches = assigneeRepository.getAllBranches();

        return new AssigneesResponse().toBuilder()
                .collaborators(collaborators)
                .employees(employees)
                .branches(branches)
                .build();
    }
}
