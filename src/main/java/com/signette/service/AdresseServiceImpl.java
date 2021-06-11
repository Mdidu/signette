package com.signette.service;

import com.signette.domains.AdresseEntity;
import com.signette.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService{

    @Autowired
    AdresseRepository adresseRepository;

    @Override
    public void add(AdresseEntity adresse) {
//        adresseRepository.save(adresse);
    }

    @Override
    public void delete(AdresseEntity adresse) {
        adresseRepository.delete(adresse);
    }

    @Override
    public void update(AdresseEntity adresse) {
        adresseRepository.save(adresse);
    }

    @Override
    public List<AdresseEntity> findAll() {
        return adresseRepository.findAll();
    }

    @Override
    public AdresseEntity findById(int id) {
        return adresseRepository.findById(id).get();
    }

    @Override
    public AdresseEntity addAdresse(AdresseEntity adresse) {
        AdresseEntity address = adresseRepository.save(adresse);
        return address;
    }
}
