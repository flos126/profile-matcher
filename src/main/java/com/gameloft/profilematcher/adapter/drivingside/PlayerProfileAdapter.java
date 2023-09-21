package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerProfileAdapter implements PlayerProfilePort {

    private final PlayerProfileService playerProfileService;

    private final CustomMapper mapper;

    @Override
    public PlayerProfileDto getPlayerProfile(String playerProfile) {
        return mapper.convertToType(
                playerProfileService.getPlayerFullProfile(playerProfile),
                PlayerProfileDto.class
        );
    }
}
