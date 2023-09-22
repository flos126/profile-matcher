package com.gameloft.profilematcher.adapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class InventoryDto {

    private int cash; // 123,
    private int coins; // : 123,
    private Map<String, Integer> items;
}
