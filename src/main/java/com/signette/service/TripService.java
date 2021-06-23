package com.signette.service;

import com.signette.domains.Trip;

import java.util.List;

public interface TripService extends GlobalService<Trip>{

    List<Trip> findTripByClient(Long id);
}
