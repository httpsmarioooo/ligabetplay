package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.JudgeDTO;
import java.util.List;

public interface JudgeService {
    JudgeDTO guardarNuevoJudge(JudgeDTO judgeDTO) throws Exception;
    JudgeDTO buscarJudgePorId(Integer id) throws Exception;
    JudgeDTO modificarJudge(JudgeDTO judgeDTO) throws Exception;
    List<JudgeDTO> obtenerJudges();
}
