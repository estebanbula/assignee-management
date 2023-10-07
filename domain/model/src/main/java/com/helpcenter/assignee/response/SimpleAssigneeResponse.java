package com.helpcenter.assignee.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SimpleAssigneeResponse {

    private String assigneeId;
    private String fullName;
    private String email;
    private String company;
    private String city;
}
