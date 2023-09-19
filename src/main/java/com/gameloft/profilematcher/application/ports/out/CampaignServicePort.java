package com.gameloft.profilematcher.application.ports.out;

import com.gameloft.profilematcher.adapter.dto.CampaignDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignServicePort {

    List<CampaignDto> getCurrentCampaigns();
}
