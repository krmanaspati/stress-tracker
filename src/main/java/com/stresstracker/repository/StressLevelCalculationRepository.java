package com.stresstracker.repository;

import com.stresstracker.entity.StressLevelCalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressLevelCalculationRepository extends JpaRepository<StressLevelCalculationEntity,String> {
}
