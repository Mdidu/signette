package com.signette.service;

import com.signette.domains.Address;
import com.signette.domains.Post;
import com.signette.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void add(Address adresse) {
//        addressRepository.save(adresse);
    }

    @Override
    public Address addAdresse(Address adresse) {
        Address address = addressRepository.save(adresse);
        return address;
    }

    @Override
    public void delete(Address adresse) {
        addressRepository.delete(adresse);
    }

    @Override
    public void update(Address adresse) {
        addressRepository.save(adresse);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return addressRepository.findById(id).get();
    }
}

