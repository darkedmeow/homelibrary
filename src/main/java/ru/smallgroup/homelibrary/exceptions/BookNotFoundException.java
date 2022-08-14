package ru.smallgroup.homelibrary.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id) {
        super("Could not find book - id:" + id);
    }

    public BookNotFoundException(String msg) {
        super("Could not find - " + msg);
    }
}
