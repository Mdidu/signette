package com.signette.service;

import com.signette.domains.Center;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CenterService extends GlobalService<Center> {

    Page<Center> findByCenterName( String centerName, Pageable pageable);

    Page<Center> findAll(Pageable pageable);

}
