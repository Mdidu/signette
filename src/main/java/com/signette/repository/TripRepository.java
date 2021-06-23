package com.signette.repository;

import com.signette.domains.Client;
import com.signette.domains.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {

    List<Trip> findTripByClient(Client id);


}
