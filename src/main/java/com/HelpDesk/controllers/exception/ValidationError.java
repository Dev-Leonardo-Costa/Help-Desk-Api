package com.HelpDesk.controllers.exception;

import com.HelpDesk.exceptions.StanderError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StanderError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error,String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fildName, String message) {
        this.errors.add(new FieldMessage(fildName,message));
    }
}
