package com.fiap.salesForce.controllers.handlers;

import com.fiap.salesForce.dto.exceptions.CustomError;
import com.fiap.salesForce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// Classe que trata as exceções lançadas pelos controllers
@ControllerAdvice
public class ControllerExceptionHandler {
    // Trata exceções de requisições com resource não encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
