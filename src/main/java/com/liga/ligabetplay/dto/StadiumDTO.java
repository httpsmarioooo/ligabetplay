package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StadiumDTO {
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;
}
