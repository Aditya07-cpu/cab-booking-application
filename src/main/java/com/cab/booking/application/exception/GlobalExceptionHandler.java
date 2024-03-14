package com.cab.booking.application.exception;

import com.cab.booking.application.dtos.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoUserFoundException.class, DriverNotFoundException.class})
    public ResponseEntity<ResponseObject> handleException(Exception exception) {
        ResponseObject responseObject = new ResponseObject();

        responseObject.setMessage(exception.getMessage());
        responseObject.setSuccess(false);
        responseObject.setData(null);

        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }
}
