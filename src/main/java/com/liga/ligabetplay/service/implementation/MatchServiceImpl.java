package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.domain.Stadium;
import com.liga.ligabetplay.domain.Team;
import com.liga.ligabetplay.dto.MatchDTO;
import com.liga.ligabetplay.mapper.MatchMapper;
import com.liga.ligabetplay.repository.MatchRepository;
import com.liga.ligabetplay.repository.StadiumRepository;
import com.liga.ligabetplay.repository.TeamRepository;
import com.liga.ligabetplay.service.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final StadiumRepository stadiumRepository;

    public MatchServiceImpl(MatchRepository matchRepository, TeamRepository teamRepository, StadiumRepository stadiumRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.stadiumRepository = stadiumRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchDTO guardarNuevoMatch(MatchDTO matchDTO) throws Exception {
        if(matchDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        // Validar la fecha después de validar el ID
        if (matchDTO.getMatchDate() == null) {
            throw new Exception("La fecha no puede ser nula");
        }

        // Validar que la fecha no esté en el pasado
        Date today = new Date(); // Fecha actual
        if (matchDTO.getMatchDate().before(today)) {
            throw new Exception("La fecha no puede estar en el pasado");
        }

        if(matchDTO.getHomeTeamId() == null) {
            throw new Exception("El HomeTeamId  no debe de ser nulo");
        }

        if(matchDTO.getAwayTeamId() == null) {
            throw new Exception("El AwayTeamId  no debe de ser nulo");
        }

        if(matchDTO.getStadiumId() == null) {
            throw new Exception("El StadiumId no debe de ser nulo");
        }

        // Validar que los equipos local y visitante no sean los mismos
        if (matchDTO.getHomeTeamId().equals(matchDTO.getAwayTeamId())) {
            throw new Exception("No se puede crear un partido con el mismo equipo como local y visitante");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);
        Team homeTeam = teamRepository.getReferenceById(matchDTO.getHomeTeamId());
        Team awayTeam = teamRepository.getReferenceById(matchDTO.getAwayTeamId());
        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());

        if (homeTeam == null) {
            throw new Exception("El Home Team no existe");
        }
        if (awayTeam == null) {
            throw new Exception("El Away Team no existe");
        }
        if (stadium == null) {
            throw new Exception("El Stadium no existe");
        }

        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setStadium(stadium);
        match = matchRepository.save(match);
        return MatchMapper.domainToDto(match);
    }

    @Override
    @Transactional(readOnly = true)
    public MatchDTO buscarMatchPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Match match = matchRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Match  con el id" +id));
        return MatchMapper.domainToDto(match);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MatchDTO modificarMatch(MatchDTO matchDTO) throws Exception {
        if(matchDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        // Validar la fecha después de validar el ID
        if (matchDTO.getMatchDate() == null) {
            throw new Exception("La fecha no puede ser nula");
        }

        // Validar que la fecha no esté en el pasado
        Date today = new Date(); // Fecha actual
        if (matchDTO.getMatchDate().before(today)) {
            throw new Exception("La fecha no puede estar en el pasado");
        }

        if(matchDTO.getHomeTeamId() == null) {
            throw new Exception("El HomeTeamId  no debe de ser nulo");
        }

        if(matchDTO.getAwayTeamId() == null) {
            throw new Exception("El AwayTeamId  no debe de ser nulo");
        }

        if(matchDTO.getStadiumId() == null) {
            throw new Exception("El StadiumId no debe de ser nulo");
        }

        // Validar que los equipos local y visitante no sean los mismos
        if (matchDTO.getHomeTeamId().equals(matchDTO.getAwayTeamId())) {
            throw new Exception("No se puede crear un partido con el mismo equipo como local y visitante");
        }

        Match match = MatchMapper.dtoToDomain(matchDTO);
        Team homeTeam = teamRepository.getReferenceById(matchDTO.getHomeTeamId());
        Team awayTeam = teamRepository.getReferenceById(matchDTO.getAwayTeamId());
        Stadium stadium  = stadiumRepository.getReferenceById(matchDTO.getStadiumId());

        if (homeTeam == null) {
            throw new Exception("El Home Team no existe");
        }
        if (awayTeam == null) {
            throw new Exception("El Away Team no existe");
        }
        if (stadium == null) {
            throw new Exception("El Stadium no existe");
        }

        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setStadium(stadium);
        match = matchRepository.save(match);
        return MatchMapper.domainToDto(match);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatchDTO> obtenerMatches() {
        List<Match>listaMatches = matchRepository.findAll();
        List<MatchDTO>matchesDTO = MatchMapper.domainToDTOList(listaMatches);
        return MatchMapper.domainToDTOList(listaMatches);
    }
}
