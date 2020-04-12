package com.deepwav.fattony.service;

import java.util.Optional;

import com.deepwav.fattony.model.Player;
import com.deepwav.fattony.model.Room;
import com.deepwav.fattony.model.payload.PlayerRequest;
import com.deepwav.fattony.model.payload.PlayerResponse;
import com.deepwav.fattony.repository.PlayerRepository;
import com.deepwav.fattony.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RoomRepository roomRepository;

    public PlayerResponse createPlayer(PlayerRequest request) {
        PlayerResponse response = new PlayerResponse();
        Optional<Room> room = roomRepository.findById(request.getRoomid());
        if (room.isPresent()) {
            Player player = new Player();
            player.setDead(false);
            player.setRoom(room.get());
            player.setPlayerName(request.getName());
            player.setRole(request.getRole());
            player.setRoomKey(request.getRoomkey());

            Player created = playerRepository.save(player);
            response.setPlayerid(created.getId());
            response.setDead(false);
            response.setName(created.getPlayerName());
            response.setRole(created.getRole());
            response.setRoomkey(created.getRoomKey());
        }
        return response;
    }

    public PlayerResponse getPlayer(long playerid) {
        PlayerResponse response = new PlayerResponse();
        Optional<Player> op_player = playerRepository.findById(playerid);
        if (op_player.isPresent()) {
            Player player = op_player.get();
            response.setDead(player.isDead());
            response.setName(player.getPlayerName());
            response.setPlayerid(player.getId());
            response.setRole(player.getRole());
            response.setRoomid(player.getRoom().getId());
            response.setRoomkey(player.getRoomKey());
        }
        return response;
    }

    public PlayerResponse updatePlayer(PlayerRequest request) {

        PlayerResponse response = new PlayerResponse();
        Optional<Player> op_player = playerRepository.findById(request.getPlpayerid());
        if (op_player.isPresent()) {
            Player player = op_player.get();
            player.setDead(request.isDead());
            player.setVote(request.getVote());
            player.setGesture(request.getGesture());
            player.setSight(request.isSight());
            playerRepository.save(player);
        }
        return response;
    }

}