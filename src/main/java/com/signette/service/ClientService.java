package com.signette.service;

import com.signette.domains.Client;

import java.util.List;

public interface ClientService extends GlobalService<Client> {

    List<Client> findClientByClientWording(String name);
}
