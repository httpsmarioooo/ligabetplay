package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.EventType;
import com.liga.ligabetplay.dto.EventTypeDTO;

import java.util.List;

public class EventTypeMapper {
    public static EventType dtoToDomain(EventTypeDTO eventTypeDTO){
        return EventType.builder()
                .id(eventTypeDTO.getId())
                .name(eventTypeDTO.getName())
                .build();
    }

    public static EventTypeDTO domainToDto(EventType eventType) {
        return EventTypeDTO.builder().
                id(eventType.getId()).
                name(eventType.getName()).
                build();
    }

    public static List<EventType> dtoToDomainList(List<EventTypeDTO> eventTypesDTO) {
        return eventTypesDTO.stream().map(EventTypeMapper::dtoToDomain).toList();
    }

    public static List<EventTypeDTO> domainToDTOList(List<EventType> eventTypes) {
        return eventTypes.stream().map(EventTypeMapper::domainToDto).toList();
    }
}
