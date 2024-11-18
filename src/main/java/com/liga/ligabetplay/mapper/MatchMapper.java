package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.dto.MatchDTO;

import java.util.List;

public class MatchMapper {
    public static Match dtoToDomain (MatchDTO matchDTO){
        return Match.builder()
                .id(matchDTO.getId())
                .matchDate(matchDTO.getMatchDate())
                .build();
    }

    public static MatchDTO domainToDto(Match match){
        return MatchDTO.builder()
                .id(match.getId())
                .matchDate(match.getMatchDate())
                .homeTeamId(match.getHomeTeam() != null ? match.getHomeTeam().getId() : null)
                .awayTeamId(match.getAwayTeam() != null ? match.getAwayTeam(). getId() : null)
                .stadiumId(match.getStadium() != null ? match.getStadium().getId() : null)
                .build();
    }

    public static List<Match> dtoToDomainList(List<MatchDTO>matchDTO){
        return matchDTO.stream().map(MatchMapper::dtoToDomain).toList();
    }

    public static List<MatchDTO> domainToDTOList(List<Match> matches){
        return matches.stream().map(MatchMapper::domainToDto).toList();
    }
}
