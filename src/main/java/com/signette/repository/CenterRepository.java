package com.signette.repository;

import com.signette.domains.Center;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {

    @Query("select c from Center c where upper(c.centerName) like upper(concat('%', :title, '%'))")
    Page<Center> findByCenterNameContainsIgnoreCase (@Param("title") String centerName, Pageable pageable);

}
