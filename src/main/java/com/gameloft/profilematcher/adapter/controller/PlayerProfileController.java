package com.gameloft.profilematcher.adapter.controller;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player-profile")
@RequiredArgsConstructor
public class PlayerProfileController {

    private final PlayerProfilePort playerProfileInPort;

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<PlayerProfileDto> getProfileConfig(@PathVariable("player_id") String playerId){
        var player = playerProfileInPort.getPlayerProfile(playerId);
        return ResponseEntity.ok(player);
    }

}
