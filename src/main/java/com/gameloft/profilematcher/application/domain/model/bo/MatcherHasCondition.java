package com.gameloft.profilematcher.application.domain.model.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatcherHasCondition {

    private List<String> country; // ["US","RO","CA"],
    private List<String> items; //  ["item_1"]

}
