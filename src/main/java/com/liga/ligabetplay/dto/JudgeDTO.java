package com.liga.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JudgeDTO {
    private Integer id;
    private String name;
    private Integer roleId;
}
