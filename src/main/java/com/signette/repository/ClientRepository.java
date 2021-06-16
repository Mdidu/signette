package com.signette.repository;

import com.signette.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findClientByClientWording(String name);

}
