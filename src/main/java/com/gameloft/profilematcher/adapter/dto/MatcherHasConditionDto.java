package com.gameloft.profilematcher.adapter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatcherHasConditionDto {

    private List<String> country; // ["US","RO","CA"],
    private List<String> items; //  ["item_1"]

}
