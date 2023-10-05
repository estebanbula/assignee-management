package com.helpcenter.usecase;

import com.helpcenter.assignee.gateway.IAssignee;
import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;
import com.helpcenter.assignee.response.AssigneesResponse;
import com.helpcenter.events.gateway.IEventGateway;
import com.helpcenter.events.model.Event;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AssigneeUseCase {

    private final IAssignee assigneeRepository;
    private final IEventGateway eventGateway;

    public Worker addWorker(Worker worker) {
        return assigneeRepository.addWorker(worker);
    }

    public Branch addBranch(Branch branch) {
        return Optional.of(assigneeRepository.addBranch(branch))
                .map(brn -> {
                    this.eventGateway.emitEvent(this.buildEvent());
                    return brn;
                }).orElseThrow();
    }

    public Employee addEmployee(Employee employee) {
        return Optional.of(assigneeRepository.addEmployee(employee))
                .map(emp -> {
                    this.eventGateway.emitEvent(this.buildEvent());
                    return emp;
                }).orElseThrow();
    }

    public Collaborator addCollaborator(Collaborator collaborator) {
        return Optional.of(assigneeRepository.addCollaborator(collaborator))
                .map(coll -> {
                    this.eventGateway.emitEvent(this.buildEvent());
                    return coll;
                }).orElseThrow();
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

    private Event buildEvent() {
        return new Event().toBuilder()
                .status("UPDATED")
                .message("Assignee list updated")
                .assignees(this.retrieveAssignees())
                .build();
    }
}
