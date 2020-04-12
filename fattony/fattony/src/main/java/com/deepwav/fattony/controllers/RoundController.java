package com.deepwav.fattony.controllers;

import com.deepwav.fattony.model.payload.RoundRequest;
import com.deepwav.fattony.model.payload.RoundResponse;
import com.deepwav.fattony.service.RoundService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/round")
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping("create")
    public RoundResponse createRound(@RequestBody RoundRequest request) {
        return roundService.createRound(request);
    }

    @GetMapping("{roundid}")
    public RoundResponse getRound(@PathVariable long roundid) {
        return roundService.getRound(roundid);
    }

    @PatchMapping("update")
    public RoundResponse updateRound(@RequestBody RoundRequest request) {
        return roundService.updateRound(request);
    }

}