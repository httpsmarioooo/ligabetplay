package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.MatchDTO;
import java.util.List;

public interface MatchService {
    MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception;
    MatchDTO buscarMatchPorId(Integer id) throws Exception;
    MatchDTO modificarMatch(MatchDTO matchDTO) throws Exception;
    List<MatchDTO> obtenerMatches();
}
