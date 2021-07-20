package com.signette.service;

import com.signette.domains.Center;
import com.signette.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository centerRepository;

    @Override
    public void add(Center center) {
        centerRepository.save(center);
    }

    @Override
    public void delete(Center center) {
        centerRepository.delete(center);
    }

    @Override
    public void update(Center center) {
        centerRepository.save(center);
    }

    @Override
    public List<Center> findAll() {
        return null;
    }

    @Override
    public Page<Center> findAll(Pageable pageable) {
        return centerRepository.findAll(pageable);
    }

    @Override
    public Center findById(long id) {
        return centerRepository.findById(id).get();
    }

    @Override
    public Page<Center> findByCenterName(String centerName, Pageable pageable) { return centerRepository.findByCenterNameContainsIgnoreCase(centerName, pageable); }


}
