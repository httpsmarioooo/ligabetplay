package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.JudgePerMatch;
import com.liga.ligabetplay.dto.JudgePerMatchDTO;

import java.util.List;

public class JudgePerMatchMapper {
    public static JudgePerMatch dtoToDomain(JudgePerMatchDTO judgePerMatchDTO){
        return JudgePerMatch.builder()
                .id(judgePerMatchDTO.getId())
                .build();
    }

    // Duda ES domainToDto O domainToDTO
    public static JudgePerMatchDTO domainToDto(JudgePerMatch judgePerMatch){
        return JudgePerMatchDTO.builder()
                .id(judgePerMatch.getId())
                .matchId((judgePerMatch.getMatch() != null) ? judgePerMatch.getMatch().getId() : null)
                .judgeId((judgePerMatch.getJudge() != null) ? judgePerMatch.getJudge() .getId() : null)
                .build();
    }

    public static List<JudgePerMatch> dtoToDomainList(List<JudgePerMatchDTO>judgePerMatchDTO){
        return judgePerMatchDTO.stream().map(JudgePerMatchMapper::dtoToDomain).toList();
    }

    public static List<JudgePerMatchDTO> domainToDTOList(List<JudgePerMatch> judgePerMatches){
        return judgePerMatches.stream().map(JudgePerMatchMapper::domainToDto).toList();
    }
}
