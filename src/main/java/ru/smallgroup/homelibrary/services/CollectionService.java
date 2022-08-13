package ru.smallgroup.homelibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.repositories.CollectionRepository;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository repository;

    @Autowired
    public CollectionService(CollectionRepository repository) {
        this.repository = repository;
    }

    public List<Collection> findAllByUserId(Long id) {
        return repository.findAllByOwnerId(id).orElseThrow();
    }

}