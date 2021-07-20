package com.signette.service;

import com.signette.domains.Center;
import com.signette.domains.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService extends GlobalService<Client> {

    List<Client> findClientByClientWording(String name);
    Page<Client> findByClientByClientWording( String centerName, Pageable pageable);
    Page<Client> findAll(Pageable pageable);
}
