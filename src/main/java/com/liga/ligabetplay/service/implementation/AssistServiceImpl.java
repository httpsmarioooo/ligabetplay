package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Assist;
import com.liga.ligabetplay.domain.Goal;
import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.domain.Player;
import com.liga.ligabetplay.dto.AssistDTO;
import com.liga.ligabetplay.mapper.AssistMapper;
import com.liga.ligabetplay.repository.AssistRepository;
import com.liga.ligabetplay.repository.GoalRepository;
import com.liga.ligabetplay.repository.MatchRepository;
import com.liga.ligabetplay.repository.PlayerRepository;
import com.liga.ligabetplay.service.AssistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssistServiceImpl implements AssistService {

    private final AssistRepository assistRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final GoalRepository goalRepository;

    public AssistServiceImpl(AssistRepository assistRepository, MatchRepository matchRepository, PlayerRepository playerRepository, GoalRepository goalRepository) {
        this.assistRepository = assistRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.goalRepository = goalRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AssistDTO guardarNuevoAssists(AssistDTO assistDTO) throws Exception {
        if(assistDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(assistDTO.getMatchId() == null) {
            throw new Exception("El MatchId debe no debe de ser nulo");
        }

        if(assistDTO.getPlayerId() == null) {
            throw new Exception("El PlayerId no debe de ser nulo");
        }

        if(assistDTO.getGoalId() == null) {
            throw new Exception("El GoalId no debe de ser nulo");
        }

        Assist assist = AssistMapper.dtoToDomain(assistDTO);
//        Player player = playerRepository.getReferenceById(assistDTO.getPlayerId());
//        Match match = matchRepository.getReferenceById(assistDTO.getMatchId());
//        Goal goal = goalRepository.getReferenceById(assistDTO.getGoalId());
//
//        if (player == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (match == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (goal == null){
//            throw new Exception("El Gol no existe");
//        }
//
//
//        assist.setPlayer(player);
//        assist.setMatch(match);
//        assist.setGoal(goal);

        Match match = matchRepository.findById(assistDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        assist.setMatch(match);

        Player player = playerRepository.findById(assistDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
        assist.setPlayer(player);

        Goal goal = goalRepository.findById(assistDTO.getGoalId())
                .orElseThrow(() -> new Exception("El Goal no existe"));
        assist.setGoal(goal);
        
        assist = assistRepository.save(assist);
        return AssistMapper.domainToDto(assist);
    }

    @Override
    @Transactional(readOnly = true)
    public AssistDTO buscarAssistPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Assist assist = assistRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra la Assist con el id" +id));
        return AssistMapper.domainToDto(assist);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AssistDTO modificarAssist(AssistDTO assistDTO) throws Exception {
        if(assistDTO.getId() == null) {
            throw new Exception("El id no puede ser nulo");
        }

        if(assistDTO.getMatchId() == null) {
            throw new Exception("El MatchId debe no debe de ser nulo");
        }

        if(assistDTO.getPlayerId() == null) {
            throw new Exception("El PlayerId no debe de ser nulo");
        }

        if(assistDTO.getGoalId() == null) {
            throw new Exception("El GoalId no debe de ser nulo");
        }

        Assist assist = AssistMapper.dtoToDomain(assistDTO);
//        Player player = playerRepository.getReferenceById(assistDTO.getPlayerId());
//        Match match = matchRepository.getReferenceById(assistDTO.getMatchId());
//        Goal goal = goalRepository.getReferenceById(assistDTO.getGoalId());
//
//        if (player == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (match == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (goal == null){
//            throw new Exception("El Gol no existe");
//        }
//
//        assist.setPlayer(player);
//        assist.setMatch(match);
//        assist.setGoal(goal);

        Match match = matchRepository.findById(assistDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        assist.setMatch(match);

        Player player = playerRepository.findById(assistDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
        assist.setPlayer(player);

        Goal goal = goalRepository.findById(assistDTO.getGoalId())
                .orElseThrow(() -> new Exception("El Goal no existe"));
        assist.setGoal(goal);


        assist = assistRepository.save(assist);
        return AssistMapper.domainToDto(assist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssistDTO> obtenerAssists() {
        List<Assist>listaAssits = assistRepository.findAll();
        List<AssistDTO>assitsDTO = AssistMapper.domainToDTOList(listaAssits);
        return AssistMapper.domainToDTOList(listaAssits);
    }
}
