package com.signette.service;

import com.signette.domains.Address;
import com.signette.domains.Center;
import com.signette.domains.Client;
import com.signette.domains.Trip;
import com.signette.repository.TripRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.assertj.core.api.Assertions.assertThat;

class TripServiceImplTest {

    @Mock
    TripRepository tripRepository;

    @InjectMocks
    TripServiceImpl tripService;

    Trip trip1;

    Center center1;
    Client client1;
    Address address1;

    List<Trip> listTrip;

    @BeforeEach
    void setUp(){
        listTrip = new ArrayList<>();

        address1 = new Address(1,"Le Quesnoy", "France", 8, "Rue du Java");
        client1 = new Client(1,"Jeanmarsseau@gmail.com","0663899509","Ecole Jules Vernes",address1);
        center1 = new Center(1,"comment","mail","centerName","centerPhone","centerPicture");

        trip1 = new Trip(1,new Date(2021,20,20),new Date(2021,10,10),client1,center1);

        listTrip.add(trip1);

        initMocks(this);

        when(tripRepository.findAll()).thenReturn(listTrip);
        when(tripRepository.save(Matchers.any(Trip.class))).thenReturn(trip1);
        when(tripRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(trip1));
        when(tripRepository.findTripByClient(Matchers.any())).thenReturn(List.of(trip1));
    }

    @Test
    void add() {
        tripService.add(trip1);
        verify(tripRepository).save(trip1);
    }

    @Test
    void delete() {
        tripService.delete(trip1);
        verify(tripRepository).delete(trip1);
    }

    @Test
    void update() {
        Trip trip3 = new Trip(1,new Date(2021,10,20),new Date(2021,10,1),client1,center1);

        tripService.update(trip3);
        verify(tripRepository).save(trip3);

        assertThat(trip1.getTripEndDate()).isNotEqualTo(trip3.getTripEndDate());
    }

    @Test
    void findAll() {
        List<Trip> trips = tripService.findAll();
        assertThat(trips.size()).isEqualTo(1);
    }

    @Test
    void findById() {
        Trip trip = tripService.findById(1);
        assertThat(trip.getTripId()).isEqualTo(trip1.getTripId());
    }

    @Test
    void findTripByClient() {
        List<Trip> trips = tripService.findTripByClient(client1.getClientId());
        List<Trip> trips2 = new ArrayList<>();
        trips2.add(trip1);

        assertThat(trips.size()).isEqualTo(trips2.size());
    }
}
