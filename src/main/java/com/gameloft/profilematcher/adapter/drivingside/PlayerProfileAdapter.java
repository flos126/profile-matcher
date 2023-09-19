package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerProfileAdapter implements PlayerProfilePort {

    private final PlayerProfileService playerProfileService;

    @Override
    public PlayerProfileDto getPlayerProfile(String playerProfile) {
        return null;
    }
}
