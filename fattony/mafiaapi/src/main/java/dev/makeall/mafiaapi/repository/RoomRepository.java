package dev.makeall.mafiaapi.repository;

import java.util.List;
import java.util.Optional;

import dev.makeall.mafiaapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomkey(String roomkey);

}