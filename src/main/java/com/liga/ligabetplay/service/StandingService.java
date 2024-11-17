package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.StandingDTO;
import java.util.List;

public interface StandingService {
    StandingDTO guardarNuevoStanding(StandingDTO standingDTO) throws Exception;
    StandingDTO buscarStandingPorId(Integer id) throws Exception;
    StandingDTO modificarStanding(StandingDTO standingDTO) throws Exception;
    List<StandingDTO> obtenerStandings();
}
