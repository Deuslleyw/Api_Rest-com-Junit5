package com.deusley.api_rest.exceptions;

public class DataIntegratyViolationException extends RuntimeException {
    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
