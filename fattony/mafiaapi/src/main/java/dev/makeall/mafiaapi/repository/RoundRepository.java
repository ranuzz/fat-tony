package dev.makeall.mafiaapi.repository;

import dev.makeall.mafiaapi.model.Room;
import dev.makeall.mafiaapi.model.Round;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {

    List<Round> findByRoom(Room room);

}