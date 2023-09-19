package com.gameloft.profilematcher.adapter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignMatcherDto {

    private MatcherLevelDto level;
    private MatcherHasConditionDto hasConditionDto;
    private MatcherDoesNotHaveConditionDto doesNotHaveConditionDto;

}
