package com.gameloft.profilematcher.adapter.drivenside;

import com.gameloft.profilematcher.adapter.dto.CampaignDto;
import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import com.gameloft.profilematcher.application.ports.out.CampaignServicePort;
import com.gameloft.profilematcher.utils.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignServiceAdapter implements CampaignServicePort {

    @Value("${campaignServiceUrl}")
    private String campaignUrl;

    private final CustomMapper mapper;

    @Override
    public List<Campaign> getCurrentCampaigns() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CampaignDto[]> result = restTemplate.getForEntity(campaignUrl, CampaignDto[].class);
        CampaignDto[] campaigns = result.getBody();

        if(campaigns == null) return List.of();

        return List.of(campaigns).stream()
                .map(c ->mapper.convertToType(c, Campaign.class))
                .toList();
    }
}
