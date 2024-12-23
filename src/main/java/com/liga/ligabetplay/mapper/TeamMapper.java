package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Team;
import com.liga.ligabetplay.dto.TeamDTO;

import java.util.List;

public class TeamMapper {
    public static Team dtoToDomain(TeamDTO teamDTO){
        return Team.builder()
                .id(teamDTO.getId())
                .name(teamDTO.getName())
                .initial(teamDTO.getInitial())
                .build();

//        Team team = new Team();
//        team.setId(teamDTO.getId());
//        team.setName(teamDTO.getName());
//        team.setInitial(teamDTO.getInitial());
//        return team;
    }

    public static TeamDTO domainToDto(Team team){
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .initial(team.getInitial())
                .stadiumId(team.getStadium() != null ? team.getStadium().getId() : null)
                .coachId(team.getCoach() != null ? team.getCoach().getId() : null)
                .build();
    }

    public static List<Team> dtoToDomainList(List<TeamDTO> teamsDTO){
        return teamsDTO.stream().map(TeamMapper::dtoToDomain).toList();
    }

    public static List<TeamDTO>domainToDTOList(List<Team>teams){
        return teams.stream().map(TeamMapper::domainToDto).toList();
    }
}
