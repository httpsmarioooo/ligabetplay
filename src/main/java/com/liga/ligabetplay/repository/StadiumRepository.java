package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
    Boolean existsByStadiumId(Integer stadiumId);
}
