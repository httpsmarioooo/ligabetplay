package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, Integer> {
}
