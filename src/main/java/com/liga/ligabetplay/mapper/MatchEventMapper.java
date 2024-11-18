package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.MatchEvent;
import com.liga.ligabetplay.dto.MatchEventDTO;

import java.util.List;

public class MatchEventMapper {
    public static MatchEvent dtoToDomain (MatchEventDTO matchEventDTO){
        return MatchEvent.builder()
                .id(matchEventDTO.getId())
                .minute(matchEventDTO.getMinute())
                .build();
    }

    public static MatchEventDTO domainToDto (MatchEvent matchEvent){
        return MatchEventDTO.builder()
                .id(matchEvent.getId())
                .minute(matchEvent.getMinute())
                .matchId((matchEvent.getMatch() != null) ? matchEvent.getMatch().getId() : null)
                .playerId((matchEvent.getPlayer() != null) ? matchEvent.getPlayer().getId() : null)
                .eventTypeId((matchEvent.getEventType() != null) ? matchEvent.getEventType().getId() : null)
                .build();
    }

    public static List<MatchEvent> dtoToDomainList(List<MatchEventDTO>matchEventDTO){
        return matchEventDTO.stream().map(MatchEventMapper::dtoToDomain).toList();
    }

    public static List<MatchEventDTO> domainToDTOList(List<MatchEvent> matchEvents){
        return matchEvents.stream().map(MatchEventMapper::domainToDto).toList();
    }
}
