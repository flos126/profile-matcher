package com.gameloft.profilematcher.application.ports.out;

import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignServicePort {

    List<Campaign> getCurrentCampaigns();
}
