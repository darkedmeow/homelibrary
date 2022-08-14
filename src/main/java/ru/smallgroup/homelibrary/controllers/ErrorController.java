package ru.smallgroup.homelibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.smallgroup.homelibrary.exceptions.BookNotFoundException;
import ru.smallgroup.homelibrary.exceptions.CollectionNotFoundException;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ErrorController {

    //TODO add parent class ModelNotFoundException ?

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CollectionNotFoundException.class)
    public String collectionNotFound(CollectionNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundException.class)
    public String bookNotFound(BookNotFoundException ex) {
        return ex.getMessage();
    }

}
