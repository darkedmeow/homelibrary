package ru.smallgroup.homelibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.smallgroup.homelibrary.exceptions.CollectionNotFound;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ErrorController {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CollectionNotFound.class)
    public String collectionNotFound(CollectionNotFound ex) {
        return ex.getMessage();
    }

}