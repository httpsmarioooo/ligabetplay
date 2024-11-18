package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Assist;
import com.liga.ligabetplay.dto.AssistDTO;

import java.util.List;

public class AssistMapper {

    public static Assist dtoToDomain (AssistDTO assistDTO){
        return Assist.builder()
                .id(assistDTO.getId())
                .build();
    }

    public static AssistDTO domainToDto (Assist assist){
        return AssistDTO.builder()
                .id(assist.getId())
                .matchId((assist.getMatch() != null) ? assist.getMatch().getId() : null)
                .playerId((assist.getPlayer() != null) ? assist.getPlayer().getId() : null)
                .goalId((assist.getGoal() != null) ? assist.getGoal().getId() : null)
                .build();
    }

    public static List<Assist> dtoToDomainList(List<AssistDTO>assistDTO){
        return assistDTO.stream().map(AssistMapper::dtoToDomain).toList();
    }

    public static List<AssistDTO> domainToDTOList(List<Assist> assists){
        return assists.stream().map(AssistMapper::domainToDto).toList();
    }
}
