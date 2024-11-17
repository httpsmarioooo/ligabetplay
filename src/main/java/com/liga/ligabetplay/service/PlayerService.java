package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.PlayerDTO;
import java.util.List;

public interface PlayerService {
    PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception;
    PlayerDTO buscarPlayerPorId(Integer id) throws Exception;
    PlayerDTO modificarPlayer(PlayerDTO playerDTO) throws Exception;
    List<PlayerDTO> obtenerPlayers();
}
