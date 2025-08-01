package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequest {

    private String title;
    private String content;
    private String name;
    private String password;
}
