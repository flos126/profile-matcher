package com.gameloft.profilematcher.adapter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignDto {

    private String game; //        "mygame",
    private String name; //        "name":"mycampaign",
    private double priority; //  "priority": 10.5,

    private CampaignMatcherDto campaignMatcherDto;

    private String startDate; //  "2022-01-25 00:00:00Z",
    private String endDate; //  "2022-02-25 00:00:00Z",
    private boolean enabled;  // True,
    private String lastUpdated; // "2021-07-13 11:46:58Z"

}
