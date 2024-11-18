package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Coach;
import com.liga.ligabetplay.dto.CoachDTO;
import com.liga.ligabetplay.mapper.CoachMapper;
import com.liga.ligabetplay.repository.CoachRepository;
import com.liga.ligabetplay.service.CoachService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CoachDTO guardarNuevoCoach(CoachDTO coachDTO) throws Exception {
        if(coachDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (coachDTO.getName() == null || coachDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        Coach coach = CoachMapper.dtoToDomain(coachDTO);

        coach = coachRepository.save(coach);
        return CoachMapper.domainToDto(coach);
    }

    @Override
    @Transactional(readOnly = true)
    public CoachDTO buscarCoachPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Coach coach = coachRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el event type con el id " +id));
        return CoachMapper.domainToDto(coach);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public CoachDTO modificarCoach(CoachDTO coachDTO) throws Exception {
        if(coachDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (coachDTO.getName() == null || coachDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        Coach coach = CoachMapper.dtoToDomain(coachDTO);

        coach = coachRepository.save(coach);
        return CoachMapper.domainToDto(coach);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoachDTO> obtenerCoaches() {
        List<Coach>listaCoaches = coachRepository.findAll();
        List<CoachDTO>coachDTO = CoachMapper.domainToDTOList(listaCoaches);
        return CoachMapper.domainToDTOList(listaCoaches);
    }
}
