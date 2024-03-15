package com.fiap.challengeSalesForce.controllers.handlres;

import com.fiap.challengeSalesForce.dto.exceptions.CustomError;
import com.fiap.challengeSalesForce.dto.exceptions.ValidationError;
import com.fiap.challengeSalesForce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e,
                                                                   HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(),
                status.value(), "Dados inválidos", request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            validationError.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validationError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CustomError> noSuchElement(NoSuchElementException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(), status.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
