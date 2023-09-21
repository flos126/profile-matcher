package com.gameloft.profilematcher.utils;

import com.gameloft.profilematcher.application.domain.entity.ClanEntity;
import com.gameloft.profilematcher.application.domain.entity.DeviceEntity;
import com.gameloft.profilematcher.application.domain.entity.InventoryEntity;
import com.gameloft.profilematcher.application.domain.entity.PlayerProfileEntity;
import com.gameloft.profilematcher.application.ports.out.ClanEntityPersistencePort;
import com.gameloft.profilematcher.application.ports.out.DeviceEntityPersistencePort;
import com.gameloft.profilematcher.application.ports.out.InventoryEntityPersistencePort;
import com.gameloft.profilematcher.application.ports.out.PlayerProfilePersistencePort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import static com.gameloft.profilematcher.utils.Constants.DATABASE_DATE_FORMAT;

@RequiredArgsConstructor
@Service
@Slf4j
public class DataSeedHelper {

    private final PlayerProfilePersistencePort playerProfilePersistencePort;
    private final DeviceEntityPersistencePort devicePersistencePort;

    private final ClanEntityPersistencePort clanPersistencePort;

    private final InventoryEntityPersistencePort inventoryPersistencePort;

    @PostConstruct
    public void seedData() {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setModel("apple iphone 11");
        deviceEntity.setFirmware("126");
        deviceEntity.setCarrier("vodafone");
        var savedDevice = devicePersistencePort.save(deviceEntity);

        ClanEntity clanEntity = new ClanEntity();
        clanEntity.setName("Hello world clan");
        var savedClan = clanPersistencePort.save(clanEntity);

        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setCash(123);
        inventoryEntity.setCoins(123);
        inventoryEntity.getItems().putAll(Map.of("item_1", 1, "item_34", 3, "item_55", 2));
        var savedInventory = inventoryPersistencePort.save(inventoryEntity);

        PlayerProfileEntity playerProfileEntity = new PlayerProfileEntity();
        playerProfileEntity.setCredential("apple_credential");

        SimpleDateFormat smf = new SimpleDateFormat(DATABASE_DATE_FORMAT);
        String date = smf.format(new Date());
        playerProfileEntity.setCreated(date);

        playerProfileEntity.setModified(date);
        playerProfileEntity.setLastSession(date);
        playerProfileEntity.setTotalSpent(400);
        playerProfileEntity.setTotalRefund(0);
        //playerProfileEntity.setLastPurchase(");
        playerProfileEntity.setTotalTransactions(50);
        playerProfileEntity.getDevices().add(savedDevice);
        playerProfileEntity.setTotalRefund(0);
        playerProfileEntity.setLevel(3);
        playerProfileEntity.setXp("1000");
        playerProfileEntity.setTotalPlaytime(144);
        playerProfileEntity.setCountry("CA");
        playerProfileEntity.setLanguage("fr");

        var birthDate =Date.from(LocalDate.of(2000,5, 15).atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        String birtDateValue = smf.format(birthDate);
        playerProfileEntity.setBirthdate(birtDateValue);
        playerProfileEntity.setGender("male");
        playerProfileEntity.setInventory(savedInventory);
        playerProfileEntity.setClan(savedClan);
        playerProfileEntity.set_customfield("mycustom");
        var savedPlayer = playerProfilePersistencePort.save(playerProfileEntity);
        log.info("----------------- PLAYER ID TO BE USED FOR TESTING {} ----------------- ", savedPlayer.getPlayerId());
    }
}
