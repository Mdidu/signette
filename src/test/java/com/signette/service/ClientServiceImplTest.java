package com.signette.service;

import com.signette.domains.Address;
import com.signette.domains.Client;
import com.signette.domains.ERole;
import com.signette.domains.Role;
import com.signette.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class ClientServiceImplTest {

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientServiceImpl clientService;

    Client client1;
    Client client2;
    Address address1;
    Address address2;

    List<Client> listClients;

    @BeforeEach
    void setUp() {
        listClients = new ArrayList<>();
        address1 = new Address(1,"Le Quesnoy", "France", 8, "Rue du Java");
        address2 = new Address(2,"Paris", "France", 12, "Rue du Java");
        client1 = new Client(1,"Jeanmarsseau@gmail.com","0663899509","Ecole Jules Vernes",address1);
        client2 = new Client(2,"Kevinrobin@gmail.com","0688552266","Ecole du Centre",address2);

        listClients.add(client1);
        listClients.add(client2);

        initMocks(this);

        when(clientRepository.save(Matchers.any(Client.class))).thenReturn(client1);
        when(clientRepository.findAll()).thenReturn(listClients);
        when(clientRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(client1));
        when(clientRepository.findClientByClientWording(Matchers.anyString())).thenReturn(listClients);

    }

    @Test
    void add() {
        clientService.add(client1);
        verify(clientRepository).save(client1);
    }

    @Test
    void delete() {
        clientService.delete(client1);
        verify(clientRepository).delete(client1);
    }

    @Test
    void update() {
        Client getClient = clientService.findById(1L);
        Client client3 = new Client(1, "Jeanmarsseau@gmail.com", "0000000000", "Ecole Jules Vernes", address1);
        clientService.update(client3);
        verify(clientRepository).save(client3);
        assertThat(getClient.getClientPhone()).isNotEqualTo(client3.getClientPhone());
    }

    @Test
    void findAll() {
        List<Client> getClients = clientService.findAll();
        assertThat(getClients.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Client getClient = clientService.findById(1);
        assertThat(getClient.getClientId()).isEqualTo(client1.getClientId());
    }

    @Test
    void findClientByClientWording() {
        List<Client> getRole = clientService.findClientByClientWording("Ecole");
        getRole.forEach((client) -> {
            assertThat(client.getClientWording()).containsIgnoringCase("Ecole");
        });
    }
}