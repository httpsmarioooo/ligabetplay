package com.liga.ligabetplay.mapper;

import com.liga.ligabetplay.domain.Stadium;
import com.liga.ligabetplay.dto.StadiumDTO;

import java.util.List;

public class StadiumMapper {
    public static Stadium dtoToDomain(StadiumDTO stadiumDTO) {
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDTO.getId());
        stadium.setName(stadiumDTO.getName());
        stadium.setCapacity(stadiumDTO.getCapacity());
        return stadium;
    }

    public static StadiumDTO domainToDto(Stadium stadium) {
        return StadiumDTO.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .capacity(stadium.getCapacity())
                .build();
    }

    public static List<Stadium> dtoToDomainList(List<StadiumDTO>StadiumsDTO){
        return StadiumsDTO.stream().map(StadiumMapper::dtoToDomain).toList();
    }

    public static List<StadiumDTO> domainToDTOList(List<Stadium>stadiums){
        return stadiums.stream().map(StadiumMapper::domainToDto).toList();
    }
}
