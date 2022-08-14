package ru.smallgroup.homelibrary.exceptions;

public class CollectionNotFound extends RuntimeException{

    public CollectionNotFound(Long id) {
        super("Could not found collection - id:" + id);
    }

    public CollectionNotFound(String name) {
        super("Could not found collection - name:" + name);
    }

}
