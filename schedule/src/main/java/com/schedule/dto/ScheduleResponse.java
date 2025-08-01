package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    // private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        //this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
