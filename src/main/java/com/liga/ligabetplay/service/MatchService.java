package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.MatchDTO;
import java.util.List;

public interface MatchService {
    MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception;
    MatchDTO buscarMatchPorId(Integer Id) throws Exception;
    MatchDTO modificarMatch(MatchDTO playerDTO) throws Exception;
    List<MatchDTO> obtenerMatches();
}