package com.signette.repository;

import com.signette.domains.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findClientByClientWording(String name);

    @Query("select c from Client c where upper(c.clientWording) like upper(concat('%', :title, '%'))")
    Page<Client> findClientByClientWordingContainsIgnoreCase (@Param("title") String title, Pageable pageable);
}
