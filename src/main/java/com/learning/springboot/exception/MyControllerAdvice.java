package com.learning.springboot.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), exception.getStatus().value());
        return ResponseEntity.status(exception.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public void handleNPException(HttpServletResponse response, NullPointerException exception) throws IOException {
       response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
