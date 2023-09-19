package com.gameloft.profilematcher.application.domain.entity;


import com.gameloft.profilematcher.application.domain.model.bo.Campaign;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="player_profile")
@Getter
@Setter
public class PlayerProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String playerId;
    private String credential; // "apple_credential",
    private String created; // "2021-01-10 13:37:17Z",
    private String modified; // "2021-01-23 13:37:17Z",
    private String lastSession; // "2021-01-23 13:37:17Z",
    private int totalSpent; // 400,
    private int totalRefund; // 0,
    private int totalTransactions; // 5,
    private String lastPurchase; // "2021-01-22 13:37:17Z",

    @OneToMany
    private Set<DeviceEntity> devices;

    private int level; //3
    private String xp; // 1000,
    private long totalPlaytime; // 144,
    private String country;  //CA
    private String language; // fr,

    private String birthdate; //"2000-01-10 13:37:17Z",
    private String gender; //male,

    private String _customfield; // "mycustom"

    @Transient
    private List<Campaign> activeCampaigns = new ArrayList<>(); // "active_campaigns": [],
}