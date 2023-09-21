package com.gameloft.profilematcher.adapter.drivingside;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.domain.model.bo.PlayerProfile;
import com.gameloft.profilematcher.application.domain.model.service.PlayerProfileService;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PlayerProfileAdapter.class, CustomMapper.class})
class PlayerProfileAdapterTest {

    @Autowired
    private PlayerProfilePort profileAdapter;

    @MockBean
    private PlayerProfileService playerProfileServiceMock;


    @Test
    public void getPlayerProfileTest() {
        var player = new PlayerProfile();
        player.setPlayerId("abc");

        when(playerProfileServiceMock.getPlayerFullProfile(player.getPlayerId())).thenReturn(player);

        PlayerProfileDto playerDto = profileAdapter.getPlayerProfile(player.getPlayerId());
        assertNotNull(playerDto);
        assertEquals(player.getPlayerId(), playerDto.getPlayerId());
    }

}