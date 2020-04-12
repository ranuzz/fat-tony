package com.deepwav.fattony.repository;

import java.util.List;

import com.deepwav.fattony.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByRoomkey(String roomkey);

}