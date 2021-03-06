package com.deepwav.fattony.controllers;

import com.deepwav.fattony.model.payload.RoomCreateRequest;
import com.deepwav.fattony.model.payload.RoomCreateResponse;
import com.deepwav.fattony.service.RoomService;

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