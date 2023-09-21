package com.gameloft.profilematcher.application.domain.model.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gameloft.profilematcher.adapter.dto.CampaignMatcherDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.gameloft.profilematcher.utils.Constants.DATABASE_DATE_FORMAT;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Getter
@Setter
public class Campaign {

    private String game;
    private String name;
    private double priority;

    private CampaignMatcherDto campaignMatcherDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private LocalDateTime endDate;
    private boolean enabled;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern = DATABASE_DATE_FORMAT)
    private LocalDateTime lastUpdated;

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

    public boolean isActive(){
        var currentDateTime = LocalDateTime.now();
        return enabled && currentDateTime.isAfter(startDate) && currentDateTime.isBefore(endDate);
    }
}
