package ru.smallgroup.homelibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smallgroup.homelibrary.model.Store;

import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

    Optional<Store> findStoreByName(String name);

}
