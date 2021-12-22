package com.stresstracker.repository;

import com.stresstracker.entity.OxygenLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OxygenLevelRepository extends JpaRepository<OxygenLevelEntity , String> {
}
