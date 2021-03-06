package com.signette.service;

import com.signette.domains.Role;
import com.signette.domains.User;
import com.signette.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Optional<User> findByUserMail(String mail) {
        return userRepository.findByUserMail(mail);
    }

    @Override
    public boolean existsByUserMail(String mail) {
        return userRepository.existsByUserMail(mail);
    }

    @Override
    public List<User> findByUserLastname(String lastname) {
        return userRepository.findByUserLastname(lastname);
    }

    @Override
    public List<User> findByUserLastnameContainsIgnoreCaseAndRole_RoleId(String lastname, Long id) {
        return userRepository.findByUserLastnameContainsIgnoreCaseOrUserUsernameContainsIgnoreCaseAndRole_RoleId(lastname,lastname,id);
    }

    @Override
    public List<User> findUserByRole_RoleId(Long id){ return userRepository.findUserByRole_RoleId(id); }


}
