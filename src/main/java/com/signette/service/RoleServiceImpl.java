package com.signette.service;

import com.signette.domains.RoleEntity;
import com.signette.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void add(RoleEntity role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(RoleEntity role) {
        roleRepository.delete(role);
    }

    @Override
    public void update(RoleEntity role) {
        roleRepository.save(role);
    }

    @Override
    public List<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity findById(int id) {
        return roleRepository.findById(id).get();
    }
}
