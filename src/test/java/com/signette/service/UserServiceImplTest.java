package com.signette.service;

import com.signette.domains.*;
import com.signette.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    User user1;
    User user2;
    Role roleUser;
    Address address1;
    Address address2;

    List<User> listUsers;

    @BeforeEach
    void setUp() {
        List<User> listUsers = new ArrayList<>();

        address1 = new Address(1,"Le Quesnoy", "France", 8, "Rue du Java");
        address2 = new Address(2,"Paris", "France", 12, "Rue du Java");
        Date date = new Date(1995, Calendar.JANUARY,10);
        Date date2 = new Date(2005, Calendar.NOVEMBER,25);
        roleUser = new Role(1L, ERole.ROLE_USER);
        user1 = new User(1,date,date2,"Cousin","clara@gmail.com","Clara",7123456789L,"motdepasse","0663899509","Clara",address1, roleUser);
        user2 = new User(2,date,date2,"Lefevre","theo@gmail.com","Theo",7123456789L,"motdepasse","0663899509","Theo",address2, roleUser);

        listUsers.add(user1);
        listUsers.add(user2);

        initMocks(this);

        when(userRepository.save(Matchers.any(User.class))).thenReturn(user1);
        when(userRepository.findAll()).thenReturn(listUsers);
        when(userRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(user1));
        when(userRepository.findByUserMail(Matchers.anyString())).thenReturn(Optional.ofNullable(user1));
    }

    @Test
    void add() {
        userService.add(user1);
        verify(userRepository).save(user1);
    }

    @Test
    void delete() {
        userService.delete(user1);
        verify(userRepository).delete(user1);
    }

    @Test
    void update() {
        User getUser = userService.findById(1L);
        Date date = new Date(1995, Calendar.JANUARY,10);
        Date date2 = new Date(2005, Calendar.NOVEMBER,25);
        User user3 = new User(date, date2, "Cousin", "clar@gmail.com", "Clara", 7123456789L, "motdepasse", "0663899509", "Clara");

        userService.update(user3);
        verify(userRepository).save(user3);
        assertThat(getUser.getUserMail()).isNotEqualTo(user3.getUserMail());
    }

    @Test
    void findAll() {
        List<User> getUsers = userService.findAll();
        assertThat(getUsers.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        User getUser = userService.findById(1L);
        assertThat(getUser.getUserId()).isEqualTo(user1.getUserId());
    }

    @Test
    void findByUserMail() {
        Optional<User> getUser = userService.findByUserMail("clara@gmail.com");
        assertThat(getUser.get().getUserMail()).isEqualTo(user1.getUserMail());
    }

    @Test
    void existsByUserMail() {
        Optional<User> getUser = userService.findByUserMail("clara@gmail.com");
        assertTrue(getUser.isPresent());
    }

    @Test
    void findByUserLastname() {
        List<User> getUsers = userService.findByUserLastname("Cousin");
        getUsers.forEach((user) -> {
            assertThat(user.getUserLastname()).contains("Cousin");
        });
    }

    @Test
    void findByUserLastnameContainsIgnoreCaseAndRole_RoleId() {
        List<User> getUsers = userService.findByUserLastnameContainsIgnoreCaseAndRole_RoleId("Cousin",1L);
        getUsers.forEach((user) -> {
            assertThat(user.getUserLastname()).contains("Cousin");
            assertThat(user.getRole()).isEqualTo(roleUser);
        });
    }

    @Test
    void findUserByRole_RoleId() {
        List<User> getUsers = userService.findUserByRole_RoleId(1L);
        getUsers.forEach((user) -> {
            assertThat(user.getRole()).isEqualTo(roleUser);
        });

    }
}