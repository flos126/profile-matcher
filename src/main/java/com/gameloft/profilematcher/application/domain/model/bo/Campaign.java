package com.gameloft.profilematcher.application.domain.model.bo;

import com.gameloft.profilematcher.adapter.dto.CampaignMatcherDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Campaign {

    private String game; //        "mygame",
    private String name; //        "name":"mycampaign",
    private double priority; //  "priority": 10.5,

    private CampaignMatcherDto campaignMatcherDto;

    private String startDate; //  "2022-01-25 00:00:00Z",
    private String endDate; //  "2022-02-25 00:00:00Z",
    private boolean enabled;  // True,
    private String lastUpdated; // "2021-07


    public boolean campaignMatch(PlayerProfile playerProfile) {
        var has = campaignMatcherDto.getHasConditionDto();

        // Check if player's country matches campaign countries
        if(!has.getCountry().contains(playerProfile.getCountry())) return false;

        var profileItems = playerProfile.getInventory().getItems().keySet();

        // Check if player has all items required by the campaign
        if(!profileItems.containsAll(has.getItems())) return false;

        var doesNotHave = campaignMatcherDto.getDoesNotHaveConditionDto();

        // Check if player have any incompatible item with the campaign
        return profileItems.stream().noneMatch(doesNotHave.getItems()::contains);
    }
}
