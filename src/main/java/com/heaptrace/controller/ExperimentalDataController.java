package com.heaptrace.controller;

import com.heaptrace.repository.ExperimentalDataRepository;
import com.heaptrace.exceptions.SolverModeNotPassedException;
import com.heaptrace.entity.ExperimentalData;
import com.heaptrace.exceptions.CasesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ExperimentalDataController {
    @Autowired
    private ExperimentalDataRepository experimentalDataRepository;


    @PostMapping("/save")
    public ExperimentalData addExperimentalData(@RequestBody ExperimentalData experimentalData){
        experimentalData.setCreatedAt(ZonedDateTime.of(LocalDateTime.now(),ZoneOffset.UTC));
        return experimentalDataRepository.save(experimentalData);
    }

    @GetMapping("/get/all")
    public List<ExperimentalData> getExperimentalDataList(){
        return experimentalDataRepository.findAll();
    }

    @GetMapping("/get/cases")
    public List<ExperimentalData> getLastHourExperimentalDataListByMode(@RequestParam Optional<String> solverMode) throws CasesNotFoundException, SolverModeNotPassedException {

        System.err.println(ZonedDateTime.of(LocalDateTime.now().minusHours(1),ZoneOffset.UTC));
        System.err.println(ZonedDateTime.of(LocalDateTime.now(),ZoneOffset.UTC));

        if (solverMode.isPresent()) {
            String mode = solverMode.get();
            List<ExperimentalData> experimentalData = experimentalDataRepository.findBySolverModeAndCreatedAtBetween(mode,
                    ZonedDateTime.of(LocalDateTime.now().minusHours(1), ZoneOffset.UTC),
                    ZonedDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));

            if (!experimentalData.isEmpty() && experimentalData != null)
                return experimentalData;

            throw new CasesNotFoundException("No cases were generated in the last hour for " + mode + " mode");
        }

        throw new SolverModeNotPassedException("The solverMode not passed in the request param");

//        System.err.println(ZonedDateTime.now().minusHours(1));
//        System.err.println(ZonedDateTime.now());
//
//        return experimentalDataRepository.findBySolverModeAndCreatedAtBetween(solverMode,
//                ZonedDateTime.now().minusHours(1),
//                ZonedDateTime.now());
    }
}
