package com.gameloft.profilematcher;

import com.gameloft.profilematcher.adapter.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class MockCampaignService {

    @GetMapping
    public ResponseEntity<List<CampaignDto>> getCampaigns(){
        // Campaign 1 NOT ENABLED--------------------------------------------------------------------------------
        MatcherHasConditionDto hasConditionDto = new MatcherHasConditionDto();
        hasConditionDto.setCountry(List.of("US","RO","CA"));
        hasConditionDto.setItems(List.of("item_1"));

        MatcherDoesNotHaveConditionDto doesNotHaveConditionDto = new MatcherDoesNotHaveConditionDto();
        doesNotHaveConditionDto.setItems(List.of("item_4"));

        MatcherLevelDto levelDto = new MatcherLevelDto();
        levelDto.setMin(1);
        levelDto.setMax(3);

        CampaignMatcherDto matcherDto = new CampaignMatcherDto();
        matcherDto.setLevel(levelDto);
        matcherDto.setHasConditionDto(hasConditionDto);
        matcherDto.setDoesNotHaveConditionDto(doesNotHaveConditionDto);

        CampaignDto campaign = new CampaignDto();
        campaign.setName("not enabled");
        campaign.setGame("mygame");
        campaign.setPriority(10.5);
        campaign.setCampaignMatcherDto(matcherDto);
        campaign.setStartDate("2022-01-25 00:00:00");
        campaign.setEndDate("2024-02-25 00:00:00");
        campaign.setEnabled(false);
        campaign.setLastUpdated("2021-07-13 11:46:58");

        // Campaign 2 ENABLED EXPIRED-------------------------------------------------------------------------------
        MatcherHasConditionDto hasConditionDto2 = new MatcherHasConditionDto();
        hasConditionDto2.setCountry(List.of("US","RO","CA"));
        hasConditionDto2.setItems(List.of("item_1"));

        MatcherDoesNotHaveConditionDto doesNotHaveConditionDto2 = new MatcherDoesNotHaveConditionDto();
        doesNotHaveConditionDto2.setItems(List.of("item_4"));

        MatcherLevelDto levelDto2 = new MatcherLevelDto();
        levelDto2.setMin(1);
        levelDto2.setMax(3);

        CampaignMatcherDto matcherDto2 = new CampaignMatcherDto();
        matcherDto2.setLevel(levelDto2);
        matcherDto2.setHasConditionDto(hasConditionDto2);
        matcherDto2.setDoesNotHaveConditionDto(doesNotHaveConditionDto2);

        CampaignDto campaign2 = new CampaignDto();
        campaign2.setName("expired");
        campaign2.setGame("mygame");
        campaign2.setPriority(10.5);
        campaign2.setCampaignMatcherDto(matcherDto2);
        campaign2.setStartDate("2022-01-25 00:00:00");
        campaign2.setEndDate("2022-02-25 00:00:00");
        campaign2.setEnabled(true);
        campaign2.setLastUpdated("2021-07-13 11:46:58");

        // Campaign 3 ENABLED WORKING--------------------------------------------------------------------------
        MatcherHasConditionDto hasConditionDto3 = new MatcherHasConditionDto();
        hasConditionDto3.setCountry(List.of("US","RO","CA"));
        hasConditionDto3.setItems(List.of("item_1"));

        MatcherDoesNotHaveConditionDto doesNotHaveConditionDto3 = new MatcherDoesNotHaveConditionDto();
        doesNotHaveConditionDto3.setItems(List.of("item_4"));

        MatcherLevelDto levelDto3 = new MatcherLevelDto();
        levelDto3.setMin(1);
        levelDto3.setMax(3);

        CampaignMatcherDto matcherDto3 = new CampaignMatcherDto();
        matcherDto3.setLevel(levelDto3);
        matcherDto3.setHasConditionDto(hasConditionDto3);
        matcherDto3.setDoesNotHaveConditionDto(doesNotHaveConditionDto3);

        CampaignDto campaign3 = new CampaignDto();
        campaign3.setName("working");
        campaign3.setGame("mygame");
        campaign3.setPriority(10.5);
        campaign3.setCampaignMatcherDto(matcherDto3);
        campaign3.setStartDate("2023-01-25 00:00:00");
        campaign3.setEndDate("2023-12-25 00:00:00");
        campaign3.setEnabled(true);
        campaign3.setLastUpdated("2021-07-13 11:46:58");

        // Campaign 4 ENABLED HAS ITEM FAILS ----------------------------------------------------------------------
        MatcherHasConditionDto hasConditionDto4 = new MatcherHasConditionDto();
        hasConditionDto4.setCountry(List.of("US","RO","CA"));
        hasConditionDto4.setItems(List.of("item_99"));

        MatcherDoesNotHaveConditionDto doesNotHaveConditionDto4 = new MatcherDoesNotHaveConditionDto();
        doesNotHaveConditionDto4.setItems(List.of("item_4"));

        MatcherLevelDto levelDto4 = new MatcherLevelDto();
        levelDto4.setMin(1);
        levelDto4.setMax(3);

        CampaignMatcherDto matcherDto4 = new CampaignMatcherDto();
        matcherDto4.setLevel(levelDto4);
        matcherDto4.setHasConditionDto(hasConditionDto4);
        matcherDto4.setDoesNotHaveConditionDto(doesNotHaveConditionDto4);

        CampaignDto campaign4 = new CampaignDto();
        campaign4.setName("has item fails");
        campaign4.setGame("mygame");
        campaign4.setPriority(10.5);
        campaign4.setCampaignMatcherDto(matcherDto4);
        campaign4.setStartDate("2023-01-25 00:00:00");
        campaign4.setEndDate("2023-12-25 00:00:00");
        campaign4.setEnabled(true);
        campaign4.setLastUpdated("2021-07-13 11:46:58");

        // Campaign 5 ENABLED WORKING--------------------------------------------------------------------------
        MatcherHasConditionDto hasConditionDto5 = new MatcherHasConditionDto();
        hasConditionDto5.setCountry(List.of("US","RO","CA"));
        hasConditionDto5.setItems(List.of("item_1"));

        MatcherDoesNotHaveConditionDto doesNotHaveConditionDto5 = new MatcherDoesNotHaveConditionDto();
        doesNotHaveConditionDto5.setItems(List.of("item_34"));

        MatcherLevelDto levelDto5 = new MatcherLevelDto();
        levelDto5.setMin(1);
        levelDto5.setMax(3);

        CampaignMatcherDto matcherDto5 = new CampaignMatcherDto();
        matcherDto5.setLevel(levelDto5);
        matcherDto5.setHasConditionDto(hasConditionDto5);
        matcherDto5.setDoesNotHaveConditionDto(doesNotHaveConditionDto5);

        CampaignDto campaign5 = new CampaignDto();
        campaign5.setName("does not fails");
        campaign5.setGame("mygame");
        campaign5.setPriority(10.5);
        campaign5.setCampaignMatcherDto(matcherDto5);
        campaign5.setStartDate("2023-01-25 00:00:00");
        campaign5.setEndDate("2023-12-25 00:00:00");
        campaign5.setEnabled(true);
        campaign5.setLastUpdated("2021-07-13 11:46:58");

        return ResponseEntity.ok(List.of(campaign, campaign2, campaign3, campaign4, campaign5));
    }

}
