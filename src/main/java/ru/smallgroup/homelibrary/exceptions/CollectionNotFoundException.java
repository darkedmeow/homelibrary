package ru.smallgroup.homelibrary.exceptions;

public class CollectionNotFoundException extends RuntimeException{

    public CollectionNotFoundException(Long id) {
        super("Could not found collection - id:" + id);
    }

    public CollectionNotFoundException(String name) {
        super("Could not found collection - name:" + name);
    }

}
