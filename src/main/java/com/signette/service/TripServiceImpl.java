package com.signette.service;

import com.signette.domains.Post;
import com.signette.domains.Trip;
import com.signette.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TripServiceImpl implements TripService{

    @Autowired
    TripRepository tripRepository;

    @Override
    public void add(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }

    @Override
    public void update(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return tripRepository.findById(id).get();
    }
}
