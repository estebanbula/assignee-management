package com.helpcenter.jpa.repository;

import com.helpcenter.assignee.gateway.IAssignee;
import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.model.Worker;
import com.helpcenter.jpa.entity.BranchEntity;
import com.helpcenter.jpa.entity.CollaboratorEntity;
import com.helpcenter.jpa.entity.EmployeeEntity;
import com.helpcenter.jpa.entity.WorkerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AssigneeAdapterImpl implements IAssignee {

    private final WorkerRepository workerRepository;
    private final BranchRepository branchRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final EmployeeRepository employeeRepository;
    private final AssigneeRepository assigneeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Collaborator> getAllCollaborators() {
        return collaboratorRepository.findAll()
                .stream().map(collaborator -> modelMapper.map(collaborator, Collaborator.class))
                .toList();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll()
                .stream().map(employee -> modelMapper.map(employee, Employee.class))
                .toList();
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll()
                .stream().map(branch -> modelMapper.map(branch, Branch.class))
                .toList();
    }

    @Override
    public Worker addWorker(Worker worker) {
        return Optional.of(workerRepository.save(modelMapper.map(worker, WorkerEntity.class)))
                .map(savedWorker -> modelMapper.map(savedWorker, Worker.class))
                .orElseThrow();
    }

    @Override
    public Branch addBranch(Branch branch) {
        return Optional.of(branchRepository.save(modelMapper.map(branch, BranchEntity.class)))
                .map(savedBranch -> modelMapper.map(savedBranch, Branch.class))
                .orElseThrow();
    }

    @Override
    public Collaborator addCollaborator(Collaborator collaborator) {
        return Optional.of(collaboratorRepository.save(modelMapper.map(collaborator, CollaboratorEntity.class)))
                .map(savedWorker -> modelMapper.map(savedWorker, Collaborator.class))
                .orElseThrow();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(modelMapper.map(employee, EmployeeEntity.class)))
                .map(savedWorker -> modelMapper.map(savedWorker, Employee.class))
                .orElseThrow();
    }

    /*@Override
    public Optional<Assignee> assigneeById(String email) {
        return Optional.of(assigneeRepository.findByEmail(email))
                .map(assignee -> modelMapper.map(assignee, Assignee.class));
    }*/
}
