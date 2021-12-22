package com.stresstracker.repository;

import com.stresstracker.entity.TemperatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureEntity, String> {
}
