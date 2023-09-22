package com.gameloft.profilematcher.adapter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gameloft.profilematcher.application.domain.model.bo.Clan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.gameloft.profilematcher.utils.Constants.DATABASE_DATE_FORMAT;

@Getter
@Setter
public class PlayerProfileDto {

    @JsonProperty("player_id")
    private String playerId;

    private String credential; // "apple_credential",

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String modified;

    @JsonProperty("last_session")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String lastSession;

    @JsonProperty("total_spent")
    private int totalSpent; // 400,
    private int totalRefund; // 0,

    @JsonProperty("total_transactions")
    private int totalTransactions; // 5,

    @JsonProperty("last_purchase")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String lastPurchase;

    @JsonProperty("active_campaigns")
    private List<CampaignDto> activeCampaigns; // "active_campaigns": [],
    private List<DeviceDto> devices;
    private int level; //3
    private String xp; // 1000,

    @JsonProperty("total_playtime")
    private long totalPlaytime; // 144,
    private String country;  //CA
    private String language; // fr,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String birthdate;
    private String gender; //male,

    private InventoryDto inventory;
    private Clan clan;

    private String _customfield; // "mycustom"
}
