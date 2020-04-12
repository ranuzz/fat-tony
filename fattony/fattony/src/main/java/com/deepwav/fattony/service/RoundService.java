package com.deepwav.fattony.service;

import java.util.Optional;

import com.deepwav.fattony.model.Room;
import com.deepwav.fattony.model.Round;
import com.deepwav.fattony.model.payload.RoundRequest;
import com.deepwav.fattony.model.payload.RoundResponse;
import com.deepwav.fattony.repository.RoomRepository;
import com.deepwav.fattony.repository.RoundRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Autowired
    private RoomRepository roomRepository;

    public RoundResponse createRound(RoundRequest request) {
        RoundResponse response = new RoundResponse();
        Optional<Room> op_room = roomRepository.findById(request.getRoomid());
        if (op_room.isPresent()) {
            Round round = new Round();
            round.setDone(false);
            round.setRoom(op_room.get());
            round.setRoundNum(request.getRoundnum());
            round.setVotes(request.getVotes());
            Round created = roundRepository.save(round);
            response.setDone(false);
            response.setRoomid(created.getRoom().getId());
            response.setRoundid(created.getId());
            response.setVotes("");
            response.setRoundnum(created.getRoundNum());
        }
        return response;
    }

    public RoundResponse getRound(long id) {
        Optional<Round> op_round = roundRepository.findById(id);
        RoundResponse response = new RoundResponse();
        if (op_round.isPresent()) {
            Round round = op_round.get();
            response.setDone(round.isDone());
            response.setRoomid(round.getRoom().getId());
            response.setRoundid(round.getId());
            response.setRoundnum(round.getRoundNum());
            response.setVotes(round.getVotes());
        }
        return response;
    }

    public RoundResponse updateRound(RoundRequest request) {
        Optional<Round> op_round = roundRepository.findById(request.getRoundid());
        if (op_round.isPresent()) {
            Round round = op_round.get();
            round.setDone(request.isDone());
            round.setVotes(request.getVotes());
            roundRepository.save(round);
        }
        return new RoundResponse();
    }

}