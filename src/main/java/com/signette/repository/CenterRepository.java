package com.signette.repository;

import com.signette.domains.Center;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    Page<Center> findByCenterNameContaining (@Param("centerName") String centerName, Pageable pageable);

}
