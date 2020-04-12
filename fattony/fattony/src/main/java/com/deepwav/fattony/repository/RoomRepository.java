package com.deepwav.fattony.repository;

import java.util.List;
import java.util.Optional;

import com.deepwav.fattony.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomkey(String roomkey);

}