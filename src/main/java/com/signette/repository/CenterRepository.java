package com.signette.repository;

import com.signette.domains.CenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<CenterEntity, Integer> {
}
