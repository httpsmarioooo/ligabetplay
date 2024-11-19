package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Judge;
import com.liga.ligabetplay.dto.JudgeDTO;

import java.util.List;

public class JudgeMapper {
    public static Judge dtoToDomain(JudgeDTO judgeDTO){
        return Judge.builder()
                .id(judgeDTO.getId())
                .name(judgeDTO.getName())
                .build();

//        judge.setId(judgeDTO.getId());
//        judge.setName(judgeDTO.getName());
//        return judge;
    }

    public static JudgeDTO domainToDto(Judge judge){
        return JudgeDTO.builder().
                id(judge.getId()).
                name(judge.getName()).
                roleId((judge.getRole() != null) ? judge.getRole().getId() : null)
                .build();
    }

    public static List<Judge> dtoToDomainList(List<JudgeDTO> judgesDTO){
        return judgesDTO.stream().map(JudgeMapper::dtoToDomain).toList();
    }

    public static List<JudgeDTO>domainToDTOList(List<Judge> judges){
        return judges.stream().map(JudgeMapper::domainToDto).toList();
    }
}
