package com.HelpDesk.services.exceptions;

public class ObjectExceptionHandler extends  RuntimeException{
    public ObjectExceptionHandler(String message) {
        super(message);
    }

    public ObjectExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectExceptionHandler(Long id){
        this(String.format("Recurso com codígo " + id + " não encontrado!"));
    }
}
