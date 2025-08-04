package com.schedule.repository;

import com.schedule.entity.Schedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 작성자명 기준으로 목록 조회
    // findAll -> 기본 제공
    // findByName -> 기본 제공x => 직접 선언 필요 (쿼리 메서드 선언)
    List<Schedule> findByName(String name, Sort sort);
}
