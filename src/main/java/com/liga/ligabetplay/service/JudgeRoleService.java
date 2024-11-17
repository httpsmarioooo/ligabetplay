package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.JudgeRoleDTO;
import java.util.List;

public interface JudgeRoleService {
    JudgeRoleDTO guardarNuevoJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception;
    JudgeRoleDTO buscarJudgeRolePorId(Integer id) throws Exception;
    JudgeRoleDTO modificarJudgeRole(JudgeRoleDTO judgeRoleDTO) throws Exception;
    List<JudgeRoleDTO> obtenerJudgeRole();
}
