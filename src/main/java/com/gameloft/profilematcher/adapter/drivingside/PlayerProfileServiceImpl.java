package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import com.gameloft.profilematcher.application.domain.model.bo.PlayerProfile;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.ports.out.CampaignServicePort;
import com.gameloft.profilematcher.application.ports.out.PlayerProfilePersistencePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerProfileServiceImpl implements PlayerProfileService {

    private final PlayerProfilePersistencePort playerProfilePersistence;
    private final CampaignServicePort campaignServicePort;
    private final CustomMapper mapper;

    @Override
    public PlayerProfile getPlayerFullProfile(String playerId) {
        var playerProfileOptional = playerProfilePersistence.findById(playerId);
        var playerEntity = playerProfileOptional.orElseThrow(() -> new IllegalArgumentException("Player not found"));

        PlayerProfile playerProfile = mapper.convertToType(playerEntity, PlayerProfile.class);
        playerProfile.setActiveCampaigns(getPlayerActiveCampaigns(playerProfile));
        log.debug("Player info updated");
        return playerProfile;
    }

    private List<Campaign> getPlayerActiveCampaigns(PlayerProfile player) {
        var campaigns = campaignServicePort.getCurrentCampaigns();
        if (campaigns.isEmpty()) return List.of();

        return campaigns.stream()
                .filter(Campaign::isActive)
                .map(c -> mapper.convertToType(c, Campaign.class))
                .filter(c -> c.campaignMatch(player))
                .toList();
    }


}
