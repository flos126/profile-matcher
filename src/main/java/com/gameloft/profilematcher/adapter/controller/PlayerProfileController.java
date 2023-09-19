package com.gameloft.profilematcher.adapter.controller;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/player-profile")
@RequiredArgsConstructor
public class PlayerProfileController {

    private final PlayerProfilePort playerProfileInPort;

    @GetMapping("/get_client_config/{player_id}")
    public PlayerProfileDto getProfileConfig(@RequestParam String playerId){
        return playerProfileInPort.getPlayerProfile(playerId);
    }

}
