package com.gameloft.profilematcher.application.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class InventoryEntity {

       @Id
       @GeneratedValue
       private long id; // 1
       private int cash; // 123,
       private int coins; // : 123,

       @ElementCollection
       @CollectionTable(name = "inventory_item_mapping",
               joinColumns = {@JoinColumn(name = "item_name", referencedColumnName = "id")})
       @Column(name = "item_count")
       private Map<String, Integer> items = new HashMap<>();
}
