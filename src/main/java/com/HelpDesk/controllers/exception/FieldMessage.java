package com.HelpDesk.controllers.exception;

public class FieldMessage {

    private String fildeName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String fildeName, String message) {
        this.fildeName = fildeName;
        this.message = message;
    }

    public String getFildeName() {
        return fildeName;
    }

    public void setFildeName(String fildeName) {
        this.fildeName = fildeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
