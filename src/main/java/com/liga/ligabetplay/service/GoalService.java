package com.liga.ligabetplay.service;

import com.liga.ligabetplay.dto.GoalDTO;
import java.util.List;

public interface GoalService {
    GoalDTO guardarNuevoGoal(GoalDTO goalDTO) throws Exception;
    GoalDTO buscarGoalPorId(Integer id) throws Exception;
    GoalDTO modificarGoal(GoalDTO goalDTO) throws Exception;
    List<GoalDTO> obtenerGoals();
}
