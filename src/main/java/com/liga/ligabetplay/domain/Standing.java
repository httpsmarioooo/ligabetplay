package com.liga.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "standings")
public class Standing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matches_played", nullable = false)
    private Integer matchesPlayed;

    @Column(nullable = false)
    private Integer wins;

    @Column(nullable = false)
    private Integer draws;

    @Column(nullable = false)
    private Integer losses;

    @Column(nullable = false)
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;
}