package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Judge;
import com.liga.ligabetplay.domain.JudgeRole;
import com.liga.ligabetplay.dto.JudgeDTO;
import com.liga.ligabetplay.mapper.JudgeMapper;
import com.liga.ligabetplay.repository.JudgeRepository;
import com.liga.ligabetplay.repository.JudgeRoleRepository;
import com.liga.ligabetplay.service.JudgeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {

    private final JudgeRepository judgeRepository;
    private final JudgeRoleRepository judgeRoleRepository;

    public JudgeServiceImpl(JudgeRepository judgeRepository, JudgeRoleRepository judgeRoleRepository) {
        this.judgeRepository = judgeRepository;
        this.judgeRoleRepository = judgeRoleRepository;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeDTO guardarNuevoJudge(JudgeDTO judgeDTO) throws Exception {
        if(judgeDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (judgeDTO.getName() == null || judgeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (judgeDTO.getRoleId() == null) {
            throw new Exception("El RoleId no debe ser nulo o vacío");
        }

        Judge judge = JudgeMapper.dtoToDomain(judgeDTO);
        JudgeRole judgeRole = judgeRoleRepository.getReferenceById(judgeDTO.getRoleId());

        if (judgeRole == null){
            throw new Exception("El JudgeRole no existe");
        }

        judge.setRole(judgeRole);
        judgeRepository.save(judge);
        return JudgeMapper.domainToDto(judge);
    }

    @Override
    @Transactional(readOnly = true)
    public JudgeDTO buscarJudgePorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Judge judge = judgeRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el judgde con el id" +id));
        return JudgeMapper.domainToDto(judge);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JudgeDTO modificarJudge(JudgeDTO judgeDTO) throws Exception {
        if(judgeDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (judgeDTO.getName() == null || judgeDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (judgeDTO.getRoleId() == null) {
            throw new Exception("El RoleId no debe ser nulo o vacío");
        }

        Judge judge = JudgeMapper.dtoToDomain(judgeDTO);
        JudgeRole judgeRole = judgeRoleRepository.getReferenceById(judgeDTO.getRoleId());

        if (judgeRole == null){
            throw new Exception("El Player no existe");
        }

        judge.setRole(judgeRole);
        judgeRepository.save(judge);
        return JudgeMapper.domainToDto(judge);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JudgeDTO> obtenerJudges() {
        List<Judge>listaJudges = judgeRepository.findAll();
        List<JudgeDTO>judgesDTO = JudgeMapper.domainToDTOList(listaJudges);
        return JudgeMapper.domainToDTOList(listaJudges);
    }
}
