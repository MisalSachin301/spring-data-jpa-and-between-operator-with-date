package com.heaptrace.exceptions;

import com.heaptrace.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CasesNotFoundException.class})
    public ResponseEntity<Response<Object>> handleCasesNotFoundException(CasesNotFoundException casesNotFoundException){

        return new ResponseEntity<>(new Response<>(
                "",casesNotFoundException.getMessage(), HttpStatus.NOT_FOUND
        ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {SolverModeNotPassedException.class})
    public ResponseEntity<Response<Object>> handleSolverModeNotPassedException(SolverModeNotPassedException solverModeNotPassedException){

        return new ResponseEntity<>(new Response<>(
                "",solverModeNotPassedException.getMessage(), HttpStatus.NOT_FOUND
        ),HttpStatus.NOT_FOUND);
    }
}
