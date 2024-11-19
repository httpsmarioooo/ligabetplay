package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Stadium;
import com.liga.ligabetplay.dto.StadiumDTO;
import com.liga.ligabetplay.mapper.StadiumMapper;
import com.liga.ligabetplay.repository.StadiumRepository;
import com.liga.ligabetplay.service.StadiumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;

    public StadiumServiceImpl(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO guardarNuevoStadium(StadiumDTO stadiumDTO) throws Exception {
        if(stadiumDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (stadiumDTO.getName() == null || stadiumDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (stadiumDTO.getLocation() == null || stadiumDTO.getLocation().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        if(stadiumDTO.getCapacity() == null) {
            throw new Exception("La capacidad no debe de ser nulo");
        }

        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);
        return StadiumMapper.domainToDto(stadium);
    }

    @Override
    @Transactional(readOnly = true)
    public StadiumDTO buscarStadiumPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Stadium stadium = stadiumRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Stadium con el id " +id));
        return StadiumMapper.domainToDto(stadium);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public StadiumDTO modificarStadium(StadiumDTO stadiumDTO) throws Exception {
        if(stadiumDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (stadiumDTO.getName() == null || stadiumDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (stadiumDTO.getLocation() == null || stadiumDTO.getLocation().isBlank()) {
            throw new Exception("La ciudad no debe ser nulo o vacío");
        }

        if(stadiumDTO.getCapacity() == null) {
            throw new Exception("La capacidad no debe de ser nulo");
        }

        Stadium stadium = StadiumMapper.dtoToDomain(stadiumDTO);
        stadium = stadiumRepository.save(stadium);
        return StadiumMapper.domainToDto(stadium);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StadiumDTO> obtenerStadiums() {
        List<Stadium>listaStadiums = stadiumRepository.findAll();
        List<StadiumDTO>stadiumDTO = StadiumMapper.domainToDTOList(listaStadiums);
        return StadiumMapper.domainToDTOList(listaStadiums);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void eliminarStadium(Integer id) throws Exception {
        if (id == null || id.equals(0)) {
            throw new Exception("El id no puede ser nulo o cero");
        }

        Boolean existeStadium = stadiumRepository.existsById(id);
        if (existeStadium == false) {
            throw new Exception("El id del stadium no existe " +id+". Por lo tanto no se puede eliminar");
        }
        
        stadiumRepository.deleteById(id);
    }
}
