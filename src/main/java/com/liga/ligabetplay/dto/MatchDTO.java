package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
    private Integer id;
    private Date matchDate;
    private Integer homeTeamId;
    private Integer awayTeamId;
    private Integer stadiumId;
}
