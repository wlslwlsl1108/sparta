package com.schedule.service;

import com.schedule.dto.ScheduleRequest;
import com.schedule.dto.ScheduleResponse;
import com.schedule.dto.ScheduleUpRequest;
import com.schedule.dto.ScheduleUpResponse;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                //savedSchedule.getPassword(),
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

    // CRUD - "U (Update)"  => 수정
    @Transactional
    public ScheduleUpResponse update(Long scheduleId, ScheduleUpRequest scheduleUpRequest) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 scheduleId가 없습니다.")
        );
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
    public void deleteSchedule(Long scheduleId) {
        boolean b = scheduleRepository.existsById(scheduleId);
        if (!b) {
            throw new IllegalArgumentException("해당하는 scheduleId가 없습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
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
                //schedule.getPassword(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}

