package com.liga.ligabetplay.service.implementation;

import com.liga.ligabetplay.domain.Coach;
import com.liga.ligabetplay.domain.Stadium;
import com.liga.ligabetplay.domain.Team;
import com.liga.ligabetplay.dto.TeamDTO;
import com.liga.ligabetplay.mapper.TeamMapper;
import com.liga.ligabetplay.repository.CoachRepository;
import com.liga.ligabetplay.repository.StadiumRepository;
import com.liga.ligabetplay.repository.TeamRepository;
import com.liga.ligabetplay.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    private final StadiumRepository stadiumRepository;
    private final CoachRepository coachRepository;

    public TeamServiceImpl(TeamRepository teamRepository, StadiumRepository stadiumRepository, CoachRepository coachRepository) {
        this.teamRepository = teamRepository;
        this.stadiumRepository = stadiumRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TeamDTO guardarNuevoTeam(TeamDTO teamDTO) throws Exception {

        if (teamDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        if (teamDTO.getName() == null || teamDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (teamDTO.getStadiumId() == null) {
            throw new Exception("El Stadium no debe ser nulo o vacío");
        }

        if (teamDTO.getCoachId() == null) {
            throw new Exception("El Coach no debe ser nulo o vacío");
        }

        Team team = TeamMapper.dtoToDomain(teamDTO);

        // Asignacion de las llaves foraneas sovbre etsa entidad
        Stadium stadium = stadiumRepository.findById(teamDTO.getStadiumId())
                .orElseThrow(() -> new Exception("El Stadium no existe"));
        team.setStadium(stadium);

        Coach coach = coachRepository.findById(teamDTO.getCoachId())
                .orElseThrow(() -> new Exception("El Coach no existe"));
        team.setCoach(coach);

        team = teamRepository.save(team);
        return TeamMapper.domainToDto(team);

    }

    @Override
    @Transactional(readOnly = true)
    public TeamDTO buscarTeamPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) {
            throw new Exception("El id no puede estar vacio ni ser 0");
        }

        Team team = teamRepository.findById(id)
                .orElseThrow (() -> new Exception("No se encuentra el Team con el id" +id));
        return TeamMapper.domainToDto(team);
    }

    @Override
    @Transactional(readOnly = true)
    public TeamDTO buscarEquipoPorInicial(String initial) throws Exception {
        // Validar el codigo que llegue al servicio
        if(initial == null || initial.equals("")) {
            throw new Exception("La inicial del Team no puede ser nulo o vacío");
        }

        // Buscar el país por incicial si no existe lanzar una excepción
        Team team = teamRepository.findByInitial(initial)
                .orElseThrow(() -> new Exception("No se encuentra el Team con la inicial " + initial));

        // Convertir el país a un DTO y retornar
        return TeamMapper.domainToDto(team);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TeamDTO modificarTeam(TeamDTO teamDTO) throws Exception {
        if (teamDTO.getId() == null) {
            throw new Exception("El id no debe de ser nulo");
        }

        if (teamDTO.getName() == null || teamDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (teamDTO.getStadiumId() == null) {
            throw new Exception("El Stadium no debe ser nulo o vacío");
        }

        if (teamDTO.getCoachId() == null) {
            throw new Exception("El Coach no debe ser nulo o vacío");
        }

        Team team = TeamMapper.dtoToDomain(teamDTO);

        // Asignacion de las llaves foraneas sovbre etsa entidad
        Stadium stadium = stadiumRepository.findById(teamDTO.getStadiumId())
                .orElseThrow(() -> new Exception("El Stadium no existe"));
        team.setStadium(stadium);

        Coach coach = coachRepository.findById(teamDTO.getCoachId())
                .orElseThrow(() -> new Exception("El Coach no existe"));
        team.setCoach(coach);

        team = teamRepository.save(team);
        return TeamMapper.domainToDto(team);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> obtenerTeams() {
        List<Team>listaTeams = teamRepository.findAll();
        List<TeamDTO>teamDTO = TeamMapper.domainToDTOList(listaTeams);
        return TeamMapper.domainToDTOList(listaTeams);
    }
}
