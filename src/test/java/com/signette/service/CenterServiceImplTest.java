package com.signette.service;

import com.signette.domains.Address;
import com.signette.domains.Center;
import com.signette.domains.Trip;
import com.signette.repository.CenterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CenterServiceImplTest {

    @Mock
    CenterRepository centerRepository;

    @InjectMocks
    CenterServiceImpl centerService;

    Center center1;
    Center center2;

    List<Center> listCenter;

    @BeforeEach
    void setUp(){
        listCenter = new ArrayList<>();

        center1 = new Center(1,"comment","mail","centerName","centerPhone","centerPicture");
        center1 = new Center(2,"comment2","mail2","centerName2","centerPhone2","centerPicture2");

        listCenter.add(center1);
        listCenter.add(center2);

        initMocks(this);

        when(centerRepository.findAll()).thenReturn(listCenter);
        when(centerRepository.save(Matchers.any(Center.class))).thenReturn(center1);
        when(centerRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(center1));
        //when(centerRepository.findByCenterNameContaining(center1.getCenterName())).thenReturn(List.of(center1));
    }

    @Test
    void add() {
        centerService.add(center1);
        verify(centerRepository).save(center1);
    }

    @Test
    void delete() {
        centerService.delete(center1);
        verify(centerRepository).delete(center1);
    }

    @Test
    void update() {

        Center center3 = new Center(2,"comment3","mail2","centerName2","centerPhone2","centerPicture2");

        centerService.update(center3);
        verify(centerRepository).save(center3);

        assertThat(center1.getCenterComment()).isNotEqualTo(center3.getCenterComment());
    }

    @Test
    void findAll() {
        List<Center> centers = centerService.findAll();
        assertThat(centers.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Center center = centerService.findById(1);
        assertThat(center.getCenterId()).isEqualTo(center1.getCenterId());
    }

    /*@Test
    void findByCenterName() {
        List<Center> center = centerService.findByCenterName(center1.getCenterName());
        List<Center> center2=new ArrayList<>();
        center2.add(center1);

        assertThat(center.size()).isEqualTo(center2.size());
    }*/
}
