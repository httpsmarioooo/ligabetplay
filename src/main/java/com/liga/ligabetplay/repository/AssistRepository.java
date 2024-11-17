package com.liga.ligabetplay.repository;
import com.liga.ligabetplay.domain.Assist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistRepository extends JpaRepository<Assist, Integer> {

}
