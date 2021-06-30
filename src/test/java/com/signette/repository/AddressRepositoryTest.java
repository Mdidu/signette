package com.signette.repository;

import com.signette.domains.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@ActiveProfiles("test")
//@ExtendWith(MockitoExtension.class)
public class AddressRepositoryTest {

//    @Mock
    Address address;
    Address savedAddress;

    @Autowired
    private AddressRepository addressRepository;

    @BeforeEach
    public void setup() {
        address = new Address("Le Quesnoy", "France", 8, "Rue du Java");
    }

    @AfterEach
    public void undefObject(){
        address = null;
        savedAddress = null;
    }

    @Test
    public void shouldSaveAddress() {
        savedAddress = addressRepository.save(address);
        assertThat(savedAddress).usingRecursiveComparison().ignoringFields("addressId").isEqualTo(address);
    }

//    @Test
//    public List<Address> shouldReadAllAddress() {
//
//    }

    @Test
    @Sql("classpath:test-data.sql")
    public void shouldSaveUsersThroughSqlFile() {
        Optional<Address> test = addressRepository.findById(1l);
        assertThat(test).isNotEmpty();
    }
}
