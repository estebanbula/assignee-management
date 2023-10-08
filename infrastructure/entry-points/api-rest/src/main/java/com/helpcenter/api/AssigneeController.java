package com.helpcenter.api;

import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import com.helpcenter.assignee.response.AssigneesResponse;
import com.helpcenter.assignee.response.SimpleAssigneeResponse;
import com.helpcenter.usecase.AssigneeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/assignees", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AssigneeController {

    private final AssigneeUseCase assigneeUseCase;

    @PostMapping("/collaborator")
    public ResponseEntity<Collaborator> saveCollaborator(@RequestBody Collaborator collaborator) {
        return new ResponseEntity<>(assigneeUseCase.addCollaborator(collaborator),
                HttpStatus.CREATED);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(assigneeUseCase.addEmployee(employee),
                HttpStatus.CREATED);
    }

    @PostMapping("/branch")
    public ResponseEntity<Branch> saveBranch(@RequestBody Branch branch) {
        return new ResponseEntity<>(assigneeUseCase.addBranch(branch),
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<AssigneesResponse> getAssignees() {
        return new ResponseEntity<>(assigneeUseCase.retrieveAssignees(),
                HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<SimpleAssigneeResponse> getAssigneeById(@RequestParam("assigneeId") Integer id) {
        return new ResponseEntity<>(assigneeUseCase.assigneeById(id),
                HttpStatus.OK);
    }
}
