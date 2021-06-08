package com.signette.repository;

import com.signette.domains.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity,Integer> {
}
