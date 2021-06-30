package com.signette.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.signette.domains.Address;
import com.signette.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class AddressServiceImplTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AddressServiceImpl addressService;

    Address address1;
    Address address2;

    List<Address> listAddresses;

    @BeforeEach
    void setUp() {
        listAddresses = new ArrayList<>();

        address1 = new Address(1,"Le Quesnoy", "France", 8, "Rue du Java");
        address2 = new Address(2,"Paris", "France", 12, "Rue du Java");

        listAddresses.add(address1);
        listAddresses.add(address2);

        initMocks(this);

        when(addressRepository.save(Matchers.any(Address.class))).thenReturn(address1);
        when(addressRepository.findAll()).thenReturn(listAddresses);
        when(addressRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(address1));
    }

    @Test
    void addAdresse() {
        Address getAddress = addressService.addAdresse(address1);
        assertThat(getAddress).isEqualTo(address1);
    }

    @Test
    void delete() {
        addressService.delete(address1);
        verify(addressRepository).delete(address1);
    }

    @Test
    void update() {
        Address getAddress = addressService.findById(2);

        address2.setAddressStreet("Rue de vue");

        addressService.update(address2);
        verify(addressRepository).save(address2);

        assertThat(getAddress.getAddressStreet()).isNotEqualTo(address2.getAddressStreet());
    }

    @Test
    void findAll() {
        List<Address> getAddress = addressService.findAll();
        assertThat(getAddress.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Address getAddress = addressService.findById(1);
        assertThat(getAddress.getAddressId()).isEqualTo(address1.getAddressId());
    }
}
