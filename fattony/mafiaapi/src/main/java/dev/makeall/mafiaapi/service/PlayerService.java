package dev.makeall.mafiaapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.makeall.mafiaapi.model.Player;
import dev.makeall.mafiaapi.model.Room;
import dev.makeall.mafiaapi.model.payload.PlayerRequest;
import dev.makeall.mafiaapi.model.payload.PlayerResponse;
import dev.makeall.mafiaapi.repository.PlayerRepository;
import dev.makeall.mafiaapi.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private RoomRepository roomRepository;

    private static int MAX_PLAYERS = 8;
    private static String[] PLAYER_ROLES = new String[]{ 
        "Mafia",
        "Villager",
        "Mafia",
        "Healer",
        "Detective",
        "Sucide Bomber",
        "Villager",
        "Villager",
     };

    public PlayerResponse createPlayer(PlayerRequest request) {
        PlayerResponse response = new PlayerResponse();
        Optional<Room> room = roomRepository.findById(request.getRoomid());
        if (room.isPresent()) {
            List<PlayerResponse> players = this.roomPlayers(request.getPlpayerid());
            if (players.size() == PlayerService.MAX_PLAYERS) {
                System.out.println("max player reached");
                // TODO race condition check
                response.setPlayerid(-1);
                return response;
            }
            Player player = new Player();
            player.setDead(false);
            player.setRoom(room.get());
            player.setPlayerName(request.getName());
            player.setRole(PlayerService.PLAYER_ROLES[players.size()]);
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
        System.out.println(request.getPlpayerid());
        if (op_player.isPresent()) {
            System.out.println("found player");

            Player player = op_player.get();
            System.out.println(request.getVote());
            //player.setDead(request.isDead());
            player.setVote(request.getVote());
            //player.setGesture(request.getGesture());
            //player.setSight(request.isSight());
            playerRepository.save(player);
        } else {
            System.out.println("found player no");
        }
        return response;
    }

    public List<PlayerResponse> roomPlayers(long id) {
        Optional<Room> op_room =  roomRepository.findById(id);
        if (op_room.isPresent()) {
            Room room = op_room.get();
            List<Player> players = playerRepository.findByRoom(room);
            List<PlayerResponse> response = new ArrayList<>();
            for (Player p : players) {
                PlayerResponse resp = new PlayerResponse();
                resp.setDead(p.isDead());
                resp.setSight(p.isSight());
                resp.setPlayerid(p.getId());
                resp.setName(p.getPlayerName());
                resp.setRole(p.getRole());
                response.add(
                    resp
                );
            }
            return response;
        }
        return new ArrayList<>();
    }
}