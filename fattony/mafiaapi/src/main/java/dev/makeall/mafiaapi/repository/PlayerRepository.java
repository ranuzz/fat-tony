package dev.makeall.mafiaapi.repository;

import dev.makeall.mafiaapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByRoom(Room room);

}