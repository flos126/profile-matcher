package com.gameloft.profilematcher.application.domain.model.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Inventory {

    private int cash; // 123,
    private int coins; // : 123,
    private int item_1; // 1,
    private int item_34; //  3
    private int item_55; // 2

    private Map<String, Integer> items;
}
