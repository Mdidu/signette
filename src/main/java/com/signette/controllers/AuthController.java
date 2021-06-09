package com.signette.controllers;

import java.util.Collection;

import javax.validation.Valid;

import com.signette.domains.AdresseEntity;
import com.signette.domains.ERole;
import com.signette.domains.RoleEntity;
import com.signette.domains.UserEntity;
import com.signette.security.auth.jwt.JwtUtils;
import com.signette.security.auth.payload.request.LoginRequest;
import com.signette.security.auth.payload.request.SignupRequest;
import com.signette.security.auth.payload.response.JwtResponse;
import com.signette.security.auth.payload.response.MessageResponse;
import com.signette.service.AdresseService;
import com.signette.service.RoleService;
import com.signette.service.UserDetailsImpl;
import com.signette.service.UserService;
import com.signette.utils.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    AdresseService adresseService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getMail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userService.existsByMail(signUpRequest.getMail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserEntity user = new UserEntity(signUpRequest.getMail(),
                Encrypt.encoder().encode(signUpRequest.getPassword()));

        int idRoles = signUpRequest.getRoleId();
        RoleEntity roles = new RoleEntity();

        int idAdress = signUpRequest.getAddressId();
        AdresseEntity address = adresseService.findById(idAdress);

        if (idRoles == 2) {
            roles = roleService.findByRoleType(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else if(idRoles == 3) {
            roles = roleService.findByRoleType(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        } else {
            roles = roleService.findByRoleType(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        }

        user.setRoleByUserFkRoleId(roles);
        user.setAdresseByUserFkAddressId(address);
        userService.add(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }
}