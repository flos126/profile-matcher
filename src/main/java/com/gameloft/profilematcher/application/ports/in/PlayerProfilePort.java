package com.gameloft.profilematcher.application.ports.in;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;

public interface PlayerProfilePort {

    PlayerProfileDto getPlayerProfile(String playerProfile);
}
