package ru.smallgroup.homelibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smallgroup.homelibrary.model.Collection;

import java.util.Optional;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Long> {
    Optional<Collection> findCollectionByName(String name);
}
