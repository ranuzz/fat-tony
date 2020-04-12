package com.deepwav.fattony.repository;

import com.deepwav.fattony.model.Room;
import com.deepwav.fattony.model.Round;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {

    List<Round> findByRoom(Room room);

}