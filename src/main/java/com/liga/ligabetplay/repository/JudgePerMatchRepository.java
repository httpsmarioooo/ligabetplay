package com.liga.ligabetplay.repository;


import com.liga.ligabetplay.domain.JudgePerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgePerMatchRepository extends JpaRepository<JudgePerMatch, Integer> {
}
