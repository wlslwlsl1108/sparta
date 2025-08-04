package com.schedule.service;

import com.schedule.dto.*;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // CRUD - "C (Create)"  => 생성
    @Transactional
    public ScheduleResponse save(ScheduleRequest scheduleRequest) {
        Schedule savedSchedule = scheduleRepository.save(
                new Schedule(scheduleRequest.getTitle(),
                             scheduleRequest.getContent(),
                             scheduleRequest.getName(),
                             scheduleRequest.getPassword()));

        return new ScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
    }

    // CRUD - "R (Read)"  => 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll(
                // 정렬 -> Sort.by("컬럼명").descending() 또는 ascending()
                Sort.by("createdAt").descending()
        );
        List<ScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponse scheduleResponse = new ScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    //schedule.getPassword(), -> API 응답 제외
                    schedule.getCreatedAt(),
                    schedule.getUpdatedAt()
            );
            dtos.add(scheduleResponse);
        }
        return dtos;
    }

    // CRUD - "R (Read)"  => 작성자명으로 조회
    public List<ScheduleResponse> findSchedulesName(String name){
        List<Schedule> schedules = scheduleRepository.findByName(name,Sort.by("createdAt").descending());
                // 정렬 -> Sort.by("컬럼명").descending() 또는 ascending()

        List<ScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponse scheduleResponse = new ScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    //schedule.getPassword(), -> API 응답 제외
                    schedule.getCreatedAt(),
                    schedule.getUpdatedAt()
            );
            dtos.add(scheduleResponse);
        }
        return dtos;
    }

    // CRUD - "R (Read)"  => 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponse findSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 scheduleId가 없습니다.")
        );

        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }

    // CRUD - "U (Update)"  => 수정
    @Transactional
    public ScheduleUpResponse update(Long scheduleId, ScheduleUpRequest scheduleUpRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 scheduleId가 없습니다.")
        );

        // 비밀번호 검증
        if (!schedule.getPassword().equals(scheduleUpRequest.getPassword())) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }

        // 검증 통과
        schedule.updateContent(
                scheduleUpRequest.getTitle(),
                scheduleUpRequest.getName()
        );

        return new ScheduleUpResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getName()
        );
    }

    // CRUD - "D (Delete)"  => 삭제
    @Transactional
    public void deleteSchedule(Long scheduleId, ScheduleDeRequest scheduleDeRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 scheduleId가 없습니다.")
        );

         // 비밀번호 검증
         if (!schedule.getPassword().equals(scheduleDeRequest.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
         }
         scheduleRepository.delete(schedule);
    }


}

