package com.cab.booking.application.exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message) {
        super(message);
    }
}
