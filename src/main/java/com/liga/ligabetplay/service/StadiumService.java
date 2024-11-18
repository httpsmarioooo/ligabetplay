package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.StadiumDTO;
import java.util.List;

public interface StadiumService {
    StadiumDTO guardarNuevoStadium(StadiumDTO stadiumDTO) throws Exception;
    StadiumDTO buscarStadiumPorId(Integer id) throws Exception;
    StadiumDTO modificarStadium(StadiumDTO stadiumDTO) throws Exception;
    List<StadiumDTO> obtenerStadiums();
    void eliminarStadium(Integer id) throws Exception;

}
