package com.gameloft.profilematcher.application.domain.model.bo;


import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import com.gameloft.profilematcher.application.domain.model.bo.Clan;
import com.gameloft.profilematcher.application.domain.model.bo.Device;
import com.gameloft.profilematcher.application.domain.model.bo.Inventory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PlayerProfile {


    private String playerId; //"97983be2-98b7-11e7-90cf-082e5f28d836",
    private String credential; // "apple_credential",
    private String created; // "2021-01-10 13:37:17Z",
    private String modified; // "2021-01-23 13:37:17Z",
    private String lastSession; // "2021-01-23 13:37:17Z",
    private int totalSpent; // 400,
    private int totalRefund; // 0,
    private int totalTransactions; // 5,
    private String lastPurchase; // "2021-01-22 13:37:17Z",
    private List<Campaign> activeCampaigns; // "active_campaigns": [],
    private List<Device> devices;
    private int level; //3
    private String xp; // 1000,
    private long totalPlaytime; // 144,
    private String country;  //CA
    private String language; // fr,

    private String birthdate; //"2000-01-10 13:37:17Z",
    private String gender; //male,

    private Inventory inventory;
    private Clan clan;

    private String _customfield; // "mycustom"
}