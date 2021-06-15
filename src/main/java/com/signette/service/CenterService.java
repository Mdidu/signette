package com.signette.service;

import com.signette.domains.Center;

import java.util.List;

public interface CenterService extends GlobalService<Center> {

    List<Center> findByCenterName(String centerName);

}
