package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.application.domain.entity.PlayerProfileEntity;
import com.gameloft.profilematcher.application.domain.model.bo.PlayerProfile;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.ports.out.CampaignServicePort;
import com.gameloft.profilematcher.application.ports.out.PlayerProfilePersistencePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PlayerProfileServiceImpl.class, CustomMapper.class})
class PlayerProfileServiceImplTest {

    @Autowired
    private PlayerProfileService playerProfileService;

    @MockBean
    private PlayerProfilePersistencePort playerProfilePersistence;
    @MockBean
    private CampaignServicePort campaignServicePort;

    @Test
    public void getPlayerFullProfileThrowsExceptionTest() {
        when(playerProfilePersistence.findById(any())).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> playerProfileService.getPlayerFullProfile("abd"));
    }

    @Test
    public void getPlayerFullProfileTest() {
        PlayerProfileEntity playerProfileEntity = new PlayerProfileEntity();
        playerProfileEntity.setPlayerId("10353fd4-865e-4879-bdce-8fcf5dfd5b31");
        playerProfileEntity.setCredential("apple_credential");

        when(playerProfilePersistence.findById(playerProfileEntity.getPlayerId())).thenReturn(Optional.of(playerProfileEntity));
        when(campaignServicePort.getCurrentCampaigns()).thenReturn(List.of());

        assertDoesNotThrow(() -> playerProfileService.getPlayerFullProfile(playerProfileEntity.getPlayerId()));
        verify(campaignServicePort).getCurrentCampaigns();

    }


}