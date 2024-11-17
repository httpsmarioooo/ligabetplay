package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchEventDTO {
    private Integer id;
    private Integer minute;
    private Integer matchId;
    private Integer eventTypeId;
    private Integer playerId;
    private String player2Id;
}
