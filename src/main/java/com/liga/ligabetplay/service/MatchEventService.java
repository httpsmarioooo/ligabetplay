package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.MatchEventDTO;
import java.util.List;

public interface MatchEventService {
    MatchEventDTO guardarNuevoMatchEvent (MatchEventDTO matchEventDTO) throws Exception;
    MatchEventDTO buscarMatchEventPorId(Integer Id) throws Exception;
    MatchEventDTO modificarMatchEvent(MatchEventDTO matchEventDTO) throws Exception;
    List<MatchEventDTO> obtenerMatchEvents();
}
