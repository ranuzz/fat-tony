package com.deepwav.fattony.repository;

import com.deepwav.fattony.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByRoom(Room room);

}