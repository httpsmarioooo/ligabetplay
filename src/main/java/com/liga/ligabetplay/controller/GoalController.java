package com.liga.ligabetplay.controller;

import com.liga.ligabetplay.dto.GoalDTO;
import com.liga.ligabetplay.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {

    private GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping(value = "/guardarNuevoGoal")
    public ResponseEntity<GoalDTO> guardarNuevoGoal(@RequestBody GoalDTO goalDTO) throws Exception {
        GoalDTO goalResponse = goalService.guardarNuevoGoal(goalDTO);
        return new ResponseEntity<>(goalResponse, HttpStatus.CREATED);
    }

    @GetMapping("/buscarGoalPorId/{id}")
    public ResponseEntity<GoalDTO> buscarGoalPorId (Integer id)throws Exception {
        GoalDTO goalResponse = goalService.buscarGoalPorId(id);
        return new ResponseEntity<>(goalResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerGoals")
    public List<GoalDTO> obtenerGoals(){
        return goalService.obtenerGoals();
    }

    @PutMapping(value = "/modificarGoal")
    public ResponseEntity<GoalDTO> modificarGoal(@RequestBody GoalDTO goalDTO) throws Exception {
        GoalDTO goalResponse = goalService.modificarGoal(goalDTO);
        return new ResponseEntity<>(goalResponse, HttpStatus.CREATED);
    }
}
