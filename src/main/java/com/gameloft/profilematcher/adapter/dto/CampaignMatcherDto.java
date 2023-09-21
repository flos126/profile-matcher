package com.gameloft.profilematcher.adapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CampaignMatcherDto {

    private MatcherLevelDto level;

    @JsonProperty("has")
    private MatcherHasConditionDto hasConditionDto;

    @JsonProperty("does_not_have")
    private MatcherDoesNotHaveConditionDto doesNotHaveConditionDto;

}
