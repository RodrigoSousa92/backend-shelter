package com.example.backendshelter.exception;

import com.example.backendshelter.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ExceptionsHandler {
    @ExceptionHandler({PetNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(PetNotFound exception) {
        return new HttpErrorResponse(
                404,
                "Approach number 1",
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({ShelterNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(ShelterNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}