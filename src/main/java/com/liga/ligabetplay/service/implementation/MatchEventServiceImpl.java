package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.EventType;
import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.domain.MatchEvent;
import com.liga.ligabetplay.domain.Player;
import com.liga.ligabetplay.dto.MatchEventDTO;
import com.liga.ligabetplay.mapper.MatchEventMapper;
import com.liga.ligabetplay.repository.EventTypeRepository;
import com.liga.ligabetplay.repository.MatchEventRepository;
import com.liga.ligabetplay.repository.MatchRepository;
import com.liga.ligabetplay.repository.PlayerRepository;
import com.liga.ligabetplay.service.MatchEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchEventServiceImpl implements MatchEventService {

    private final MatchEventRepository matchEventRepository;

    private final MatchRepository matchRepository;
    private final EventTypeRepository eventTypeRepository;
    private final PlayerRepository playerRepository;

    public MatchEventServiceImpl(MatchEventRepository matchEventRepository, MatchRepository matchRepository, EventTypeRepository eventTypeRepository, PlayerRepository playerRepository) {
        this.matchEventRepository = matchEventRepository;
        this.matchRepository = matchRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.playerRepository = playerRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchEventDTO guardarNuevoMatchEvent(MatchEventDTO matchEventDTO) throws Exception {
        if (matchEventDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (matchEventDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if (matchEventDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if (matchEventDTO.getEventTypeId() == null) {
            throw new Exception("El EventType no debe de ser nulo");
        }

        if (matchEventDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        MatchEvent matchEvent = MatchEventMapper.dtoToDomain(matchEventDTO);

        Match match = matchRepository.getReferenceById(matchEventDTO.getMatchId());
        EventType eventType = eventTypeRepository.getReferenceById(matchEventDTO.getEventTypeId());
        Player player = playerRepository.getReferenceById(matchEventDTO.getPlayerId());

        if (match == null) {
            throw new Exception("El Match no existe");
        }

        if (eventType == null) {
            throw new Exception("El EventType no existe");
        }

        if (player == null) {
            throw new Exception("El Player no existe");
        }

        matchEvent.setMatch(match);
        matchEvent.setEventType(eventType);
        matchEvent.setPlayer(player);
        matchEvent = matchEventRepository.save(matchEvent);

        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public MatchEventDTO buscarMatchEventPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        MatchEvent matchEvent = matchEventRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el MatchEvent con el id " +id));
        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchEventDTO modificarMatchEvent(MatchEventDTO matchEventDTO) throws Exception {
        if (matchEventDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (matchEventDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if (matchEventDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if (matchEventDTO.getEventTypeId() == null) {
            throw new Exception("El EventType no debe de ser nulo");
        }

        if (matchEventDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        MatchEvent matchEvent = MatchEventMapper.dtoToDomain(matchEventDTO);

        Match match = matchRepository.getReferenceById(matchEventDTO.getMatchId());
        EventType eventType = eventTypeRepository.getReferenceById(matchEventDTO.getEventTypeId());
        Player player = playerRepository.getReferenceById(matchEventDTO.getPlayerId());

        if (match == null) {
            throw new Exception("El Match no existe");
        }

        if (eventType == null) {
            throw new Exception("El EventType no existe");
        }

        if (player == null) {
            throw new Exception("El Player no existe");
        }

        matchEvent.setMatch(match);
        matchEvent.setEventType(eventType);
        matchEvent.setPlayer(player);
        matchEvent = matchEventRepository.save(matchEvent);

        return MatchEventMapper.domainToDto(matchEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatchEventDTO> obtenerMatchEvents() {
        List<MatchEvent>listaMatchEvents = matchEventRepository.findAll();
        List<MatchEventDTO>matchEventsDTO = MatchEventMapper.domainToDTOList(listaMatchEvents);
        return MatchEventMapper.domainToDTOList(listaMatchEvents);
    }
}
