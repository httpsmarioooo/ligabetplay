package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Player;
import com.liga.ligabetplay.dto.PlayerDTO;

import java.util.List;

public class PlayerMapper {
    public static Player dtoToDomain (PlayerDTO playerDTO){
        return Player.builder()
                .id(playerDTO.getId())
                .name(playerDTO.getName())
                .position(playerDTO.getPosition())
                .build();
    }

    public static PlayerDTO domainToDto (Player player){
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .position(player.getPosition())
                .teamId((player.getTeam() != null) ? player.getTeam().getId() : null)
                .build();
    }

    public static List<Player> dtoToDomainList(List<PlayerDTO>playerDTO){
        return playerDTO.stream().map(PlayerMapper::dtoToDomain).toList();
    }

    public static List<PlayerDTO> domainToDTOList(List<Player> players){
        return players.stream().map(PlayerMapper::domainToDto).toList();
    }
}
