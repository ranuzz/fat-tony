package dev.makeall.mafiaapi.controllers;

import java.util.List;

import dev.makeall.mafiaapi.model.payload.PlayerRequest;
import dev.makeall.mafiaapi.model.payload.PlayerResponse;
import dev.makeall.mafiaapi.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("create")
    public PlayerResponse createPlayer(@RequestBody PlayerRequest request) {
        return playerService.createPlayer(request);
    }

    @GetMapping("{playerid}")
    public PlayerResponse getPlayer(@PathVariable long playerid) {
        return playerService.getPlayer(playerid);
    }

    @PatchMapping("update")
    public PlayerResponse updatePlayer(@RequestBody PlayerRequest request) {
        return playerService.updatePlayer(request);
    }

    @GetMapping("room/{roomid}")
    public List<PlayerResponse> getRoomPlayers(@PathVariable long roomid) {
        return playerService.roomPlayers(roomid);
    }
    

}