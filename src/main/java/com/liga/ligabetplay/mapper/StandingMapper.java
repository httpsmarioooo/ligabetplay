package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Standing;
import com.liga.ligabetplay.dto.StandingDTO;

import java.util.List;

public class StandingMapper {
    public static Standing dtoToDomain (StandingDTO standingDTO){
        return Standing.builder()
                .id(standingDTO.getId())
                .points(standingDTO.getPoints())
                .losses(standingDTO.getLosses())
                .draws(standingDTO.getDraws())
                .wins(standingDTO.getWins())
                .matchesPlayed(standingDTO.getMatchesPlayed())
                .build();
    }

    public static StandingDTO domainToDto (Standing standing){
        return StandingDTO.builder()
                .id(standing.getId())
                .points(standing.getPoints())
                .losses(standing.getLosses())
                .draws(standing.getDraws())
                .wins(standing.getWins())
                .matchesPlayed(standing.getMatchesPlayed())
                .teamId((standing.getTeam() != null) ? standing.getTeam().getId() : null)
                .build();
    }

    public static List<Standing> dtoToDomainList(List<StandingDTO>standingDTO){
        return standingDTO.stream().map(StandingMapper::dtoToDomain).toList();
    }

    public static List<StandingDTO> domainToDTOList(List<Standing> standings){
        return standings.stream().map(StandingMapper::domainToDto).toList();
    }
}
