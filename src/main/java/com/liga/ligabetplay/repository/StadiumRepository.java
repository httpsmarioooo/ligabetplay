package com.liga.ligabetplay.repository;

import com.liga.ligabetplay.domain.Stadium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Integer> {
}
