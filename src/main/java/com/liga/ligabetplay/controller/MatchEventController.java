package com.liga.ligabetplay.controller;


import com.liga.ligabetplay.dto.MatchEventDTO;
import com.liga.ligabetplay.service.MatchEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match-event")
public class MatchEventController {
    private MatchEventService matchEventService;

    public MatchEventController(MatchEventService matchEventService) {
        this.matchEventService = matchEventService;
    }

    @PostMapping(value = "/guardarNuevoMatchEvent")
    public ResponseEntity<MatchEventDTO> guardarNuevoMatchEvent(@RequestBody MatchEventDTO matchEventDTO) throws Exception {
        MatchEventDTO matchEventResponse = matchEventService.guardarNuevoMatchEvent(matchEventDTO);
        return new ResponseEntity<>(matchEventResponse, HttpStatus.CREATED);
    }

    @GetMapping("/buscarMatchEventPorId/{id}")
    public ResponseEntity<MatchEventDTO> buscarMatchEventPorId (Integer id)throws Exception {
        MatchEventDTO matchEventResponse = matchEventService.buscarMatchEventPorId(id);
        return new ResponseEntity<>(matchEventResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/obtenerMatchEvents")
    public List<MatchEventDTO> obtenerMatchEvents(){
        return matchEventService.obtenerMatchEvents();
    }

    @PutMapping(value = "/modificarMatchEvent")
    public ResponseEntity<MatchEventDTO> modificarMatchEvent(@RequestBody MatchEventDTO matchEventDTO) throws Exception {
        MatchEventDTO matchEventResponse = matchEventService.modificarMatchEvent(matchEventDTO);
        return new ResponseEntity<>(matchEventResponse, HttpStatus.CREATED);
    }
}
