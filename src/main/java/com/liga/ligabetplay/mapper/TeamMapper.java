package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Team;
import com.liga.ligabetplay.dto.TeamDTO;

import java.util.List;

public class TeamMapper {
    public static Team dtoToDomain(TeamDTO teamDTO){
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        return team;
    }

    public static TeamDTO domainToDT0(Team team){
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .stadiumId(team.getStadium() != null ? team.getStadium().getId() : null)
                .coachId(team.getCoach() != null ? team.getCoach().getId() : null)
                .build();
    }

    public static List<Team> dtoToDomainList(List<TeamDTO> teamsDTO){
        return teamsDTO.stream().map(TeamMapper::dtoToDomain).toList();
    }

    public static List<TeamDTO>domainToDTOList(List<Team>teams){
        return teams.stream().map(TeamMapper::domainToDT0).toList();
    }
}
