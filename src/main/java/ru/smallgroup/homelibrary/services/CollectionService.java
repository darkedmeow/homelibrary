package ru.smallgroup.homelibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smallgroup.homelibrary.exceptions.CollectionNotFoundException;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.repositories.CollectionRepository;
import ru.smallgroup.homelibrary.repositories.UserRepository;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public CollectionService(CollectionRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<Collection> findAllByUserId(Long id) {
        return repository.findAllByOwnerId(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Collection getCollectionById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CollectionNotFoundException(id));
    }

    public Collection addCollection(Long uid, Collection collection) {
        userRepository.findById(uid).ifPresentOrElse(
                user -> user.addCollection(collection),
                () -> {throw new UserNotFoundException(uid);}
        );
        return repository.save(collection);
    }

}
