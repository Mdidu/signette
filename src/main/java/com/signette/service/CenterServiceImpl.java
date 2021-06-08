package com.signette.service;

import com.signette.domains.CenterEntity;
import com.signette.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository centerRepository;

    @Override
    public void add(CenterEntity center) {
        centerRepository.save(center);
    }

    @Override
    public void delete(CenterEntity center) {
        centerRepository.delete(center);
    }

    @Override
    public void update(CenterEntity center) {
        centerRepository.save(center);
    }

    @Override
    public List<CenterEntity> findAll() {
        return centerRepository.findAll();
    }

    @Override
    public CenterEntity findById(int id) {
        return centerRepository.findById(id).get();
    }
}
