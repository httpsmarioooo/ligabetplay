package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchEventRepository extends JpaRepository<MatchEvent, Integer> {
}
