package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Goal;
import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.domain.Player;
import com.liga.ligabetplay.dto.GoalDTO;
import com.liga.ligabetplay.mapper.GoalMapper;
import com.liga.ligabetplay.repository.GoalRepository;
import com.liga.ligabetplay.repository.MatchRepository;
import com.liga.ligabetplay.repository.PlayerRepository;
import com.liga.ligabetplay.service.GoalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    public GoalServiceImpl(GoalRepository goalRepository, MatchRepository matchRepository, PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public GoalDTO guardarNuevoGoal(GoalDTO goalDTO) throws Exception {
        if(goalDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(goalDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(goalDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if(goalDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        Goal goal = GoalMapper.dtoToDomain(goalDTO);

//        Player player = playerRepository.getReferenceById(goalDTO.getPlayerId());
//        Match match = matchRepository.getReferenceById(goalDTO.getMatchId());
//
//        if (player == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (match == null){
//            throw new Exception("El Match no existe");
//        }
//
//        goal.setPlayer(player);
//        goal.setMatch(match);

        Match match = matchRepository.findById(goalDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        goal.setMatch(match);

        Player player = playerRepository.findById(goalDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
        goal.setPlayer(player);


        goal = goalRepository.save(goal);
        return GoalMapper.domainToDto(goal);
    }

    @Override
    @Transactional(readOnly = true)
    public GoalDTO buscarGoalPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Goal goal = goalRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Goal con el id " +id));
        return GoalMapper.domainToDto(goal);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public GoalDTO modificarGoal(GoalDTO goalDTO) throws Exception {
        if(goalDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if(goalDTO.getMinute() == null) {
            throw new Exception("El minuto no debe de ser nulo");
        }

        if(goalDTO.getMatchId() == null) {
            throw new Exception("El Matchid debe no debe de ser nulo");
        }

        if(goalDTO.getPlayerId() == null) {
            throw new Exception("El Playerid no debe de ser nulo");
        }

        Goal goal = GoalMapper.dtoToDomain(goalDTO);

//        Player player = playerRepository.getReferenceById(goalDTO.getPlayerId());
//        Match match = matchRepository.getReferenceById(goalDTO.getMatchId());
//
//        if (player == null){
//            throw new Exception("El Player no existe");
//        }
//
//        if (match == null){
//            throw new Exception("El Match no existe");
//        }
//
//        goal.setPlayer(player);
//        goal.setMatch(match);

        Match match = matchRepository.findById(goalDTO.getMatchId())
                .orElseThrow(() -> new Exception("El Match no existe"));
        goal.setMatch(match);

        Player player = playerRepository.findById(goalDTO.getPlayerId())
                .orElseThrow(() -> new Exception("El Player no existe"));
        goal.setPlayer(player);


        goal = goalRepository.save(goal);
        return GoalMapper.domainToDto(goal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GoalDTO> obtenerGoals() {
        List<Goal>listaGoals = goalRepository.findAll();
        List<GoalDTO>goalsDTO = GoalMapper.domainToDTOList(listaGoals);
        return GoalMapper.domainToDTOList(listaGoals);
    }
}
