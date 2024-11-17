package com.liga.ligabetplay.repository;
import com.liga.ligabetplay.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoacRepository extends JpaRepository<Coach, Integer> {
}
