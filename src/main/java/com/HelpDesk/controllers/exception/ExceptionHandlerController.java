package com.HelpDesk.controllers.exception;

import com.HelpDesk.exceptions.DataIntegrityViolationException;
import com.HelpDesk.exceptions.ObjectExceptionHandler;
import com.HelpDesk.exceptions.StanderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ObjectExceptionHandler.class)
    public ResponseEntity<StanderError> objectNotFoundException(ObjectExceptionHandler ex, HttpServletRequest request) {

        StanderError error = new StanderError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), "Recurso não encontrado!", request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StanderError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {

        StanderError error = new StanderError(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(), "Recurso já cadastrado!", request.getRequestURI(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
