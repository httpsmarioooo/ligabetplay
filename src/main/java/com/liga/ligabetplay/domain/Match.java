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
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date", nullable = false)
    private java.time.LocalDateTime matchDate;

    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id", nullable = false)
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "id", nullable = false)
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_id", referencedColumnName = "id", nullable = false)
    private Stadium stadium;
}