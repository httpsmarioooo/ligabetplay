package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.JudgeRole;
import com.liga.ligabetplay.dto.JudgeRoleDTO;

import java.util.List;

public class JudgeRoleMapper {
    public static JudgeRole dtoToDomain(JudgeRoleDTO judgeRoleDTO){
        JudgeRole judgeRole = new JudgeRole();
        judgeRole.setId(judgeRoleDTO.getId());
        judgeRole.setRoleName(judgeRoleDTO.getRoleName());
        return judgeRole;
    }

    public static JudgeRoleDTO domainToDto(JudgeRole judgeRole){
        return JudgeRoleDTO.builder().
                id(judgeRole.getId()).
                roleName(judgeRole.getRoleName()).
                build();
    }

    public static List<JudgeRole> dtoToDomainList(List<JudgeRoleDTO>judgeRoleDTO){
        return judgeRoleDTO.stream().map(JudgeRoleMapper::dtoToDomain).toList();
    }

    public static List<JudgeRoleDTO> domainToDTOList(List<JudgeRole> judgeRoles){
        return judgeRoles.stream().map(JudgeRoleMapper::domainToDto).toList();
    }
}
