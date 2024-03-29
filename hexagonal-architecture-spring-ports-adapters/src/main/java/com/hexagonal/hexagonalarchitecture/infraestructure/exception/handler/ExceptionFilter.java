package com.hexagonal.hexagonalarchitecture.infraestructure.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
@AllArgsConstructor
public class ExceptionFilter {


    private final HttpServletRequest request;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> exceptionInterceptor(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        List<String> fieldErrors = bindingResult.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        log.error(String.valueOf(fieldErrors));
        return new ResponseEntity(fieldErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> violationException(ConstraintViolationException e){
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<String> violationMessages = violations.stream()
                .map(violation -> "Campo: " + violation.getPropertyPath() + ", Error: " + violation.getMessage())
                .peek(log::error)
                .collect(Collectors.toList());

        return new ResponseEntity(violationMessages, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<?> postgresException(PSQLException e){
        int substring = e.getMessage().indexOf("=");
        String message = e.getMessage().substring(substring + 1).trim();
        String messageFiler = message.replaceAll("\\(|\\)", "");
        return new ResponseEntity(messageFiler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> accessDeniedException(AccessDeniedException e){
        log.error(e.toString());
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> generalException(Exception e) {
        log.error(e.toString());
        return new ResponseEntity("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
