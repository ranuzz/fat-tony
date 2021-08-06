package dev.makeall.mafiaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import dev.makeall.mafiaapi.model.payload.RoomCreateRequest;
import dev.makeall.mafiaapi.model.payload.RoomCreateResponse;
import dev.makeall.mafiaapi.model.Room;
import dev.makeall.mafiaapi.repository.RoomRepository;

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

    public RoomCreateResponse getRoom(long id) {
        Optional<Room> op_room = roomRepository.findById(id);
        RoomCreateResponse resposne = new RoomCreateResponse();
        if (op_room.isPresent()) {
            Room room = op_room.get();
            resposne.setGametype(room.getGametype());
            resposne.setName(room.getName());
            resposne.setNumplayers(room.getNumplayers());
            resposne.setRoomid(room.getId());
            resposne.setRoomkey(room.getRoomkey());
            resposne.setRules(room.getRules());
        }
        return resposne;
    }

    public RoomCreateResponse getRoomByKey(String roomkey) {
        /*
        List<Room> op_room = roomRepository.findByRoomkey(roomkey);
        if (op_room != null && op_room.size() != 0) {
            System.out.println("dasdadhgasdhfashgfashf");
            return this.getRoom(op_room.get(0).getId());
        }
        */
        System.out.println(roomkey);
        Optional<Room> op_room = roomRepository.findByRoomkey(roomkey);
        if (op_room.isPresent()) {
            return this.getRoom(op_room.get().getId());
        }
        RoomCreateResponse response = new RoomCreateResponse();
        response.setRoomid(-1);
        return response;
    }

}