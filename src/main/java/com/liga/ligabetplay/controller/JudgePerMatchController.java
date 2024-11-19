package com.liga.ligabetplay.controller;

import com.liga.ligabetplay.dto.JudgePerMatchDTO;
import com.liga.ligabetplay.service.JudgePerMatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/judge-per-match")
public class JudgePerMatchController {
    //Inyeccion de dependecias hacia CiudadServices
    private JudgePerMatchService judgePerMatchService;

    public JudgePerMatchController(JudgePerMatchService judgePerMatchService) {
        this.judgePerMatchService = judgePerMatchService;
    }

    @PostMapping(value = "/guardarNuevoJudgePerMatch")
    public ResponseEntity<JudgePerMatchDTO> guardarNuevoJudgePerMatch(@RequestBody JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        JudgePerMatchDTO judgePerMatchResponse = judgePerMatchService.guardarNuevoJudgePerMatch(judgePerMatchDTO);
        return new ResponseEntity<>(judgePerMatchResponse, HttpStatus.CREATED);
    }

    @GetMapping("/buscarJudgePerMatchPorId/{id}")
    public ResponseEntity<JudgePerMatchDTO> buscarJudgePerMatchPorId (Integer id)throws Exception {
        JudgePerMatchDTO judgePerMatchResponse = judgePerMatchService.buscarJudgePerMatchPorId(id);
        return new ResponseEntity<>(judgePerMatchResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerJudgesPerMatch")
    public List<JudgePerMatchDTO> obtenerJudgesPerMatch(){
        return judgePerMatchService.obtenerJudgesPerMatch();
    }

    @PutMapping(value = "/modificarJudgePerMatch")
    public ResponseEntity<JudgePerMatchDTO> modificarJudgePerMatch(@RequestBody JudgePerMatchDTO judgePerMatchDTO) throws Exception {
        JudgePerMatchDTO judgePerMatchResponse = judgePerMatchService.modificarJudgePerMatch(judgePerMatchDTO);
        return new ResponseEntity<>(judgePerMatchResponse, HttpStatus.CREATED);
    }
}
