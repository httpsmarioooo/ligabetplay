package com.liga.ligabetplay.controller;

import com.liga.ligabetplay.dto.CoachDTO;
import com.liga.ligabetplay.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    private CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping(value = "/guardarNuevoCoach")
    public ResponseEntity<CoachDTO> guardarNuevoCoach(@RequestBody CoachDTO coachDTO) throws Exception {
        CoachDTO coachResponse = coachService.guardarNuevoCoach(coachDTO);
        return new ResponseEntity<>(coachResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerCoaches")
    public List<CoachDTO> obtenerCoaches(){
        return coachService.obtenerCoaches();
    }

    @GetMapping("/buscarCoachPorId/{id}")
    public ResponseEntity<CoachDTO> buscarCoachPorId (Integer id)throws Exception {
        CoachDTO coachResponse = coachService.buscarCoachPorId(id);
        return new ResponseEntity<>(coachResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarCoach")
    public ResponseEntity<CoachDTO> modificarCoach(@RequestBody CoachDTO coachDTO) throws Exception {
        CoachDTO coachResponse = coachService.modificarCoach(coachDTO);
        return new ResponseEntity<>(coachResponse, HttpStatus.OK);
    }
}
