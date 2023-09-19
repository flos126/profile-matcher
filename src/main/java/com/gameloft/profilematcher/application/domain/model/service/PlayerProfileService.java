package com.gameloft.profilematcher.application.domain.model.service;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;

public interface PlayerProfileService {

    PlayerProfileDto getPlayerFullProfile(String playerId);
}
