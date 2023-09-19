package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.utils.CustomMapper;
import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.domain.model.bo.PlayerProfile;
import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import com.gameloft.profilematcher.application.ports.out.CampaignServicePort;
import com.gameloft.profilematcher.application.ports.out.PlayerProfilePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerProfileAdapterImpl implements PlayerProfileService {

    private final PlayerProfilePersistencePort playerProfilePersistence;
    private final CampaignServicePort campaignServicePort;
    private final CustomMapper mapper;

    @Override
    public PlayerProfileDto getPlayerFullProfile(String playerId) {
        var player = playerProfilePersistence.findById(playerId);
        if (player.isEmpty()) throw new IllegalArgumentException("Player not found");

        PlayerProfile playerProfile = mapper.convertToType(player, PlayerProfile.class);
        playerProfile.setActiveCampaigns(getPlayerActiveCampaigns(playerProfile));

        return null;
    }

    private List<Campaign> getPlayerActiveCampaigns(PlayerProfile player) {
        var campaigns = campaignServicePort.getCurrentCampaigns();
        if (campaigns.isEmpty()) return List.of();

        return campaigns.stream()
                .map(c -> mapper.convertToType(c, Campaign.class))
                .filter(c -> c.campaignMatch(player))
                .toList();
    }


}
