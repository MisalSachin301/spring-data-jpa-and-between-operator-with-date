package com.heaptrace.repository;

import com.heaptrace.entity.ExperimentalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface ExperimentalDataRepository extends JpaRepository<ExperimentalData, Integer> {

    List<ExperimentalData> findBySolverModeAndCreatedAtBetween(String solverMode, ZonedDateTime start, ZonedDateTime end);
}
