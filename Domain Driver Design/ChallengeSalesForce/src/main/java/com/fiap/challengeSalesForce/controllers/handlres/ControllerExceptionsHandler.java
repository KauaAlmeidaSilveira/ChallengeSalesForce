package com.fiap.challengeSalesForce.controllers.handlres;

import com.fiap.challengeSalesForce.dto.exceptions.CustomError;
import com.fiap.challengeSalesForce.dto.exceptions.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError validationError = new ValidationError(Instant.now(), status.value(), "Dados inválidos",
                request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()){
            validationError.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validationError);
    }

}
