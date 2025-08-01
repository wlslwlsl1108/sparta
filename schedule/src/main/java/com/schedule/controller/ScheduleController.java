package com.schedule.controller;

import com.schedule.dto.ScheduleRequest;
import com.schedule.dto.ScheduleResponse;
import com.schedule.dto.ScheduleUpRequest;
import com.schedule.dto.ScheduleUpResponse;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // CRUD - "C (Create)"  => 생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponse> createSchedule(
            @RequestBody ScheduleRequest scheduleRequest
    ){
        return ResponseEntity.ok(scheduleService.save(scheduleRequest));
    }

    // CRUD - "R (Read)"  => 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> getSchedules(){
        return ResponseEntity.ok(scheduleService.findSchedules());
    }

    // CRUD - "R (Read)"  => 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getSchedule(
            @PathVariable Long scheduleId
    ){
        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }

    // CRUD - "U (Update)"  => 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpRequest scheduleUpRequest
    ){
        return ResponseEntity.ok(scheduleService.update(scheduleId, scheduleUpRequest));
    }

    // CRUD - "D (Delete)"  => 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(
            @PathVariable Long scheduleId
    ){
        scheduleService.deleteSchedule(scheduleId);
    }
}
