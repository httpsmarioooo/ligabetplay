package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.EventTypeDTO;
import java.util.List;

public interface EventTypeService {
    EventTypeDTO guardarNuevoEventType(EventTypeDTO eventTypeDTO) throws Exception;
    EventTypeDTO buscarEventTypePorId(Integer id) throws Exception;
    EventTypeDTO modificarEventType(EventTypeDTO eventTypeDTO) throws Exception;
    List<EventTypeDTO> obtenerEventType();
}
