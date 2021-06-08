package com.signette.service;

import com.signette.domains.TripEntity;
import com.signette.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService{

    @Autowired
    TripRepository tripRepository;

    @Override
    public void add(TripEntity trip) {
        tripRepository.save(trip);
    }

    @Override
    public void delete(TripEntity trip) {
        tripRepository.delete(trip);
    }

    @Override
    public void update(TripEntity trip) {
        tripRepository.save(trip);
    }

    @Override
    public List<TripEntity> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public TripEntity findById(int id) {
        return tripRepository.findById(id).get();
    }
}
