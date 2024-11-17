package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.JudgeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRoleRepository extends JpaRepository<JudgeRole, Integer> {
}
