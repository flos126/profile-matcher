package com.gameloft.profilematcher.adapter.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Setter
@NoArgsConstructor
public class InventoryDto {

    @JsonProperty("cash")
    @Getter
    private int cash; // 123,

    @JsonProperty("coins")
    @Getter
    private int coins; // : 123,

    private Map<String, Integer> items = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Integer> getItems() {
        return items;
    }

}
