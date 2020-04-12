package com.deepwav.fattony.service;

import java.util.Random;

import com.deepwav.fattony.model.payload.RoomCreateRequest;
import com.deepwav.fattony.model.payload.RoomCreateResponse;
import com.deepwav.fattony.model.Room;
import com.deepwav.fattony.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    
    private String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
 
        return generatedString;
    }

    public RoomCreateResponse createRoom(RoomCreateRequest request) {
        RoomCreateResponse response = new RoomCreateResponse();
        response.setGametype(request.getGametype());
        response.setName(request.getName());
        response.setNumplayers(request.getNumplayers());
        response.setRoomkey(getRandomString());
        response.setRules(request.getRules());

        Room room = new Room();
        room.setGametype(request.getGametype());
        room.setName(request.getName());
        room.setNumplayers(request.getNumplayers());
        room.setRoomkey(response.getRoomkey());
        room.setRules(request.getRules());

        Room createdRoom = roomRepository.save(room);
        response.setRoomid(createdRoom.getId());

        return response;
    } 

}