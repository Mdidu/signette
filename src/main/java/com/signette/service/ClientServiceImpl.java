package com.signette.service;

import com.signette.domains.ClientEntity;
import com.signette.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void add(ClientEntity client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(ClientEntity client) {
        clientRepository.delete(client);
    }

    @Override
    public void update(ClientEntity client) {
        clientRepository.save(client);
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity findById(int id) {
        return clientRepository.findById(id).get();
    }
}
