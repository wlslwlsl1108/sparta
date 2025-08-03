package com.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleDeResponse {

    private Long id;
    private String password;

    public ScheduleDeResponse(Long id, String password) {
        this.id = id;
        this.password = password;
    }
}
