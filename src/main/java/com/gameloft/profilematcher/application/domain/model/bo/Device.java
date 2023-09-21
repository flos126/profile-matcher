package com.gameloft.profilematcher.application.domain.model.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Device {


       private int id; // 1
       private String model; // "apple iphone 11",
       private String carrier; // "vodafone",
       private String firmware; // "123"
}
