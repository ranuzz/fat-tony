package dev.makeall.mafiaapi.controllers;

import dev.makeall.mafiaapi.model.payload.RoomCreateRequest;
import dev.makeall.mafiaapi.model.payload.RoomCreateResponse;
import dev.makeall.mafiaapi.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("create")
    public RoomCreateResponse createRoom(@RequestBody RoomCreateRequest request) {
        return roomService.createRoom(request);
    }

    @GetMapping("{roomid}")
    public RoomCreateResponse getRoom(@PathVariable long roomid) {
        return roomService.getRoom(roomid);
    }

    @GetMapping("key/{roomkey}")
    public RoomCreateResponse getRoomByKey(@PathVariable String roomkey) {
        return roomService.getRoomByKey(roomkey);
    }


}