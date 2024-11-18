package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Coach;
import com.liga.ligabetplay.dto.CoachDTO;

import java.util.List;

public class CoachMapper {
    public static Coach dtoToDomain (CoachDTO coachDTO){
        return Coach.builder()
                .id(coachDTO.getId())
                .name(coachDTO.getName())
                .build();
    }

    public static CoachDTO domainToDto(Coach coach){
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .build();
    }

    public static List<Coach> dtoToDomainList(List<CoachDTO>coachDTO){
        return coachDTO.stream().map(CoachMapper::dtoToDomain).toList();
    }

    public static List<CoachDTO> domainToDTOList(List<Coach> coaches){
        return coaches.stream().map(CoachMapper::domainToDto).toList();
    }
}
