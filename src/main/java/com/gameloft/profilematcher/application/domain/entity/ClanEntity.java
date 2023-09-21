package com.gameloft.profilematcher.application.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clan")
@Getter
@Setter
public class ClanEntity {

       @Id
       @GeneratedValue
       private long id; // 1
       private String name; // "Hello world clan"

}
