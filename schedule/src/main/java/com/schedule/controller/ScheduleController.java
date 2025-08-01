package com.schedule.controller;

import com.schedule.dto.ScheduleRequest;
import com.schedule.dto.ScheduleResponse;
import com.schedule.dto.ScheduleUpRequest;
import com.schedule.dto.ScheduleUpResponse;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // CRUD - "C (Create)"  => 생성
    @PostMapping("/schedules")
    public ScheduleResponse createSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ){
        return scheduleService.save(scheduleRequest);
    }

    // CRUD - "R (Read)"  => 전체 조회
    @GetMapping("/schedules")
    public List<ScheduleResponse> getSchedules(){
        return scheduleService.findSchedules();
    }

    // CRUD - "R (Read)"  => 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ScheduleResponse getSchedule(
            @PathVariable Long scheduleId
    ){
        return scheduleService.findSchedule(scheduleId);
    }

    // CRUD - "U (Update)"  => 수정
    @PutMapping("/schedules/{scheduleId}")
    public ScheduleUpResponse updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpRequest scheduleUpRequest
    ){
        return scheduleService.update(scheduleId, scheduleUpRequest);
    }

    // CRUD - "D (Delete)"  => 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long scheduleId
    ){
        scheduleService.deleteSchedule(scheduleId);
    }
}
