package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Integer> {
}
