package com.liga.ligabetplay.controller;

import com.liga.ligabetplay.dto.MatchDTO;
import com.liga.ligabetplay.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @PostMapping(value = "/guardarNuevoMatch")
    public ResponseEntity<MatchDTO> guardarNuevoMatch(@RequestBody MatchDTO matchDTO) throws Exception {
        MatchDTO matchResponse = matchService.guardarNuevoMatch(matchDTO);
        return new ResponseEntity<>(matchResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/obtenerMatches")
    public List<MatchDTO>obtenerMatches(){
        return matchService.obtenerMatches();
    }

    @GetMapping("/buscarMatchPorId/{id}")
    public ResponseEntity<MatchDTO> buscarMatchPorId (Integer id)throws Exception {
        MatchDTO matchResponse = matchService.buscarMatchPorId(id);
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/modificarMatch")
    public ResponseEntity<MatchDTO> modificarMatch(@RequestBody MatchDTO matchDTO) throws Exception {
        MatchDTO matchResponse = matchService.modificarMatch(matchDTO);
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }
}
