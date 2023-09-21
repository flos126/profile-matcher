package com.gameloft.profilematcher.adapter.controller;

import com.gameloft.profilematcher.adapter.dto.PlayerProfileDto;
import com.gameloft.profilematcher.application.ports.in.PlayerProfilePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomMapper mapper;

    @MockBean
    private PlayerProfilePort playerProfilePortMock;

    @Test
    public void getProfileConfigTest() throws Exception {
        var player = new PlayerProfileDto();
        player.setPlayerId("abc");
        when(playerProfilePortMock.getPlayerProfile(player.getPlayerId())).thenReturn(player);

        this.mockMvc.perform(get("/player-profile/get_client_config/{player_id}", player.getPlayerId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.player_id").value(player.getPlayerId()))
                .andReturn();
    }

}