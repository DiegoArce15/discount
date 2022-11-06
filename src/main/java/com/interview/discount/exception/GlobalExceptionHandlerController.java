package com.interview.discount.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<ExceptionResponse> handleInteralErrorException(Exception ex){
        log.error("Internal error message: {}, Exception name: {}", ex.getMessage(), ex.getClass().getSimpleName(), ex);

        var response = new ExceptionResponse.ExceptionResponseBuilder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .code("0001: Internal server error")
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(RateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleRateNotFoundException(Exception ex){
        log.error("Rate not found message: {}, Exception name: {}", ex.getMessage(), ex.getClass().getSimpleName(), ex);

        var response = new ExceptionResponse.ExceptionResponseBuilder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .code("0002: Rate not found")
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
