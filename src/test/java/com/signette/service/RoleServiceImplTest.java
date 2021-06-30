package com.signette.service;

import com.signette.domains.Address;
import com.signette.domains.ERole;
import com.signette.domains.Role;
import com.signette.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class RoleServiceImplTest {

    @Mock
    RoleRepository roleRepository;

    @InjectMocks
    RoleServiceImpl roleService;

    Role roleUser;
    Role roleModerator;
    Role roleAdmin;

    List<Role> listRoles;

    @BeforeEach
    void setUp() {
        listRoles = new ArrayList<>();

        roleUser = new Role(1L, ERole.ROLE_USER);
        roleModerator = new Role(2L,ERole.ROLE_MODERATOR);
        roleAdmin = new Role(3L,ERole.ROLE_ADMIN);

        listRoles.add(roleUser);
        listRoles.add(roleModerator);
        listRoles.add(roleAdmin);

        initMocks(this);

        when(roleRepository.findAll()).thenReturn(listRoles);
        when(roleRepository.save(Matchers.any(Role.class))).thenReturn(roleUser);
        when(roleRepository.findById(Matchers.anyLong())).thenReturn(Optional.ofNullable(roleUser));
        when(roleRepository.findByRoleType(Matchers.any(ERole.class))).thenReturn(Optional.ofNullable(roleUser));
    }

    @Test
    void update() {
        Role getRole = roleService.findById(2);

        roleModerator.setRoleType(ERole.ROLE_ADMIN);

        roleService.update(roleModerator);
        verify(roleRepository).save(roleModerator);

        assertThat(getRole.getRoleType()).isNotEqualTo(roleModerator.getRoleType());
    }

    @Test
    void add() {
        roleService.add(roleUser);
        verify(roleRepository).save(roleUser);
    }

    @Test
    void delete() {
        roleService.delete(roleUser);
        verify(roleRepository).delete(roleUser);
    }
    @Test
    void findAll() {
        List<Role> getRole = roleService.findAll();
        assertThat(getRole.size()).isEqualTo(3);
    }

    @Test
    void findById() {
        Role getRole = roleService.findById(1);
        assertThat(getRole.getRoleId()).isEqualTo(roleUser.getRoleId());
    }

    @Test
    void findByRoleType() {
        Optional<Role> getRole = roleService.findByRoleType(ERole.ROLE_USER);
        assertThat(getRole.get()).isEqualTo(roleUser);
    }

}
