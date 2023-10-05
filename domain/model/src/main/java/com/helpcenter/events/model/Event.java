package com.helpcenter.events.model;

import com.helpcenter.assignee.response.AssigneesResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Event {

    private String status;
    private String message;
    private AssigneesResponse assignees;
}
