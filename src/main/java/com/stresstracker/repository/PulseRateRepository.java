package com.stresstracker.repository;

import com.stresstracker.entity.PulseRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulseRateRepository extends JpaRepository<PulseRateEntity, String> {
}
