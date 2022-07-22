package ru.smallgroup.homelibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smallgroup.homelibrary.model.Room;

import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findRoomByName(String name);
}
