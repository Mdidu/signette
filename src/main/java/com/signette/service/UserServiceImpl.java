package com.signette.service;

import com.signette.domains.UserEntity;
import com.signette.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void add(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    @Override
    public void update(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Optional<UserEntity> findByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public boolean existsByMail(String mail) {
        return userRepository.existsByMail(mail);
    }
}
