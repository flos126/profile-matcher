package com.gameloft.profilematcher.adapter.drivenside;

import com.gameloft.profilematcher.adapter.dto.CampaignDto;
import com.gameloft.profilematcher.application.ports.out.CampaignServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceAdapter implements CampaignServicePort {
    @Override
    public List<CampaignDto> getCurrentCampaigns() {
        return null;
    }
}
