package com.gameloft.profilematcher.adapter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.gameloft.profilematcher.utils.Constants.DATABASE_DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
public class CampaignDto {

    private String game;
    private String name;
    private double priority;

    @JsonProperty("matchers")
    private CampaignMatcherDto campaignMatcherDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String endDate;
    private boolean enabled;

    private String lastUpdated;

}
