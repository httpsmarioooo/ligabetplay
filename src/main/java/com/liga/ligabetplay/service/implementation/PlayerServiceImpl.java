package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Player;
import com.liga.ligabetplay.domain.Team;
import com.liga.ligabetplay.dto.PlayerDTO;
import com.liga.ligabetplay.mapper.PlayerMapper;
import com.liga.ligabetplay.repository.PlayerRepository;
import com.liga.ligabetplay.repository.TeamRepository;
import com.liga.ligabetplay.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) throws Exception {
        if(playerDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if(playerDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        if (playerDTO.getPosition() == null || playerDTO.getPosition().isBlank()) {
            throw new Exception("La posición no debe ser nula o vacía");
        }

        Player player = PlayerMapper.dtoToDomain(playerDTO);

        Team team = teamRepository.findById(playerDTO.getTeamId())
                .orElseThrow(() -> new Exception("El Team no existe"));
        player.setTeam(team);


        player = playerRepository.save(player);
        return PlayerMapper.domainToDto(player);
    }

    @Override
    @Transactional(readOnly = true)
    public PlayerDTO buscarPlayerPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Player player = playerRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Player con el id" +id));
        return PlayerMapper.domainToDto(player);

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PlayerDTO modificarPlayer(PlayerDTO playerDTO) throws Exception {
        if(playerDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if(playerDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

        if (playerDTO.getPosition() == null || playerDTO.getPosition().isBlank()) {
            throw new Exception("La posición no debe ser nula o vacía");
        }

        Player player = PlayerMapper.dtoToDomain(playerDTO);
        Team team = teamRepository.getReferenceById(playerDTO.getTeamId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        player.setTeam(team);
        player = playerRepository.save(player);
        return PlayerMapper.domainToDto(player);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDTO> obtenerPlayers() {
        List<Player>listaPlayers = playerRepository.findAll();
        List<PlayerDTO>playersDTO = PlayerMapper.domainToDTOList(listaPlayers);
        return PlayerMapper.domainToDTOList(listaPlayers);
    }
}
