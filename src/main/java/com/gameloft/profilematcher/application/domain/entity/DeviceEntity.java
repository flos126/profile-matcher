package com.gameloft.profilematcher.application.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device")
public class DeviceEntity {


       @Id
       @GeneratedValue
       private long id; // 1
       private String model; // "apple iphone 11",
       private String carrier; // "vodafone",
       private String firmware; // "123"
}
