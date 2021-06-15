package com.signette.repository;

import com.signette.domains.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    List<Center> findByCenterNameContaining (@Param("centerName") String centerName);

}
