package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AssistDTO {
    private Integer id;
    private Integer matchId;
    private Integer playerId;
    private Integer goalId;
}
