package com.gameloft.profilematcher.application.domain.model.bo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gameloft.profilematcher.utils.Constants.DATABASE_DATE_FORMAT;

@Getter
@Setter
@NoArgsConstructor
public class PlayerProfile {

    private String playerId; //"97983be2-98b7-11e7-90cf-082e5f28d836",

    private String credential; // "apple_credential",

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private Date created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private Date modified;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private String lastSession;
    private int totalSpent; // 400,
    private int totalRefund; // 0,
    private int totalTransactions; // 5,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private Date lastPurchase;
    private List<Campaign> activeCampaigns = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private int level; //3
    private String xp; // 1000,
    private long totalPlaytime; // 144,
    private String country;  //CA
    private String language; // fr,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATABASE_DATE_FORMAT)
    private Date birthdate;
    private String gender; //male,

    private Inventory inventory;
    private Clan clan;

    private String _customfield; // "mycustom"
}