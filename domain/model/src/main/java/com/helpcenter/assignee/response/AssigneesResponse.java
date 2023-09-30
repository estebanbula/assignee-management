package com.helpcenter.assignee.response;

import com.helpcenter.assignee.model.Branch;
import com.helpcenter.assignee.model.Collaborator;
import com.helpcenter.assignee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AssigneesResponse {

    private List<Collaborator> collaborators;
    private List<Employee> employees;
    private List<Branch> branches;
}
