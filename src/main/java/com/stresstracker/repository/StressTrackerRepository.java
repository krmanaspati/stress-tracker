package com.stresstracker.repository;

import com.stresstracker.entity.StressTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StressTrackerRepository extends JpaRepository<StressTrackEntity , String> {
}
