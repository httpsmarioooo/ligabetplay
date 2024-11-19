package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Judge;
import com.liga.ligabetplay.domain.JudgePerMatch;
import com.liga.ligabetplay.domain.Match;
import com.liga.ligabetplay.dto.JudgePerMatchDTO;
import com.liga.ligabetplay.mapper.JudgePerMatchMapper;
import com.liga.ligabetplay.repository.JudgePerMatchRepository;
import com.liga.ligabetplay.repository.JudgeRepository;
import com.liga.ligabetplay.repository.MatchRepository;
import com.liga.ligabetplay.service.JudgePerMatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JudgePerMatchServiceImpl implements JudgePerMatchService {

    private final JudgePerMatchRepository judgePerMatchRepository;

    private final MatchRepository matchRepository;
    private final JudgeRepository judgeRepository;

    public JudgePerMatchServiceImpl(JudgePerMatchRepository judgePerMatchRepository, MatchRepository matchRepository, JudgeRepository judgeRepository) {
        this.judgePerMatchRepository = judgePerMatchRepository;
        this.matchRepository = matchRepository;
        this.judgeRepository = judgeRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgePerMatchDTO guardarNuevoJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        if(judgePerMatchDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if(judgePerMatchDTO.getMatchId() == null) {
            throw new Exception("El MatchId no debe ser nulo");
        }

        if(judgePerMatchDTO.getJudgeId() == null) {
            throw new Exception("El JudgeId no debe ser nulo");
        }


        //Ultimas validaciones en el mismo impl en la parte final---
        JudgePerMatch judgePerMatch = JudgePerMatchMapper.dtoToDomain(judgePerMatchDTO);

        Match match = matchRepository.getReferenceById(judgePerMatchDTO.getMatchId());
        Judge judge = judgeRepository.getReferenceById(judgePerMatchDTO.getJudgeId());

        if (match == null){
            throw new Exception("El Match no existe");
        }


        if (judge == null){
            throw new Exception("El Judge no existe");
        }

        judgePerMatch.setMatch(match);
        judgePerMatch.setJudge(judge);
        judgePerMatch = judgePerMatchRepository.save(judgePerMatch);

        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = true)
    public JudgePerMatchDTO buscarJudgePerMatchPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        JudgePerMatch judgePerMatch = judgePerMatchRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el JudgePerMatch con el id " +id));
        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgePerMatchDTO modificarJudgePerMatch(JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        if(judgePerMatchDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        //2. Validaciones dependencias, llaves etc

        if(judgePerMatchDTO.getMatchId() == null) {
            throw new Exception("El MatchId no debe ser nulo");
        }

        if(judgePerMatchDTO.getJudgeId() == null) {
            throw new Exception("El JudgeId no debe ser nulo");
        }


        //Ultimas validaciones en el mismo impl en la parte final---
        JudgePerMatch judgePerMatch = JudgePerMatchMapper.dtoToDomain(judgePerMatchDTO);

        Match match = matchRepository.getReferenceById(judgePerMatchDTO.getMatchId());
        Judge judge = judgeRepository.getReferenceById(judgePerMatchDTO.getJudgeId());

        if (match == null){
            throw new Exception("El Match no existe");
        }


        if (judge == null){
            throw new Exception("El Judge no existe");
        }

        judgePerMatch.setMatch(match);
        judgePerMatch.setJudge(judge);
        judgePerMatch = judgePerMatchRepository.save(judgePerMatch);

        return JudgePerMatchMapper.domainToDto(judgePerMatch);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JudgePerMatchDTO> obtenerJudgesPerMatch() {
        List<JudgePerMatch>listaJudgesPerMatch = judgePerMatchRepository.findAll();
        List<JudgePerMatchDTO>judgesPerMatchDTO = JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
        return JudgePerMatchMapper.domainToDTOList(listaJudgesPerMatch);
    }
}
