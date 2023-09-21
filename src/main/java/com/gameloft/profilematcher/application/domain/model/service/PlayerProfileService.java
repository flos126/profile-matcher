package com.gameloft.profilematcher.application.domain.model.service;

import com.gameloft.profilematcher.application.domain.model.bo.PlayerProfile;

public interface PlayerProfileService {

    PlayerProfile getPlayerFullProfile(String playerId);
}
