package com.gameloft.profilematcher.application.domain.model.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignMatcher {

    private MatcherLevel level;
    private MatcherHasCondition hasConditionDto;
    private MatcherDoesNotHaveCondition doesNotHaveConditionDto;
}
