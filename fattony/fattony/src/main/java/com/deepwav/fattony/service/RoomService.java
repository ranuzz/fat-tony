package com.deepwav.fattony.service;

import com.deepwav.fattony.model.payload.RoomCreateRequest;
import com.deepwav.fattony.model.payload.RoomCreateResponse;
import com.deepwav.fattony.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomCreateResponse createRoom(RoomCreateRequest request) {
        RoomCreateResponse response = new RoomCreateResponse();
        return response;
    } 

}