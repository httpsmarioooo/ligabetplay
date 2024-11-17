package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandingDTO {
    private Integer id;
    private Integer teamId;
    private Integer matchesPlayed;
    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer points;
}
