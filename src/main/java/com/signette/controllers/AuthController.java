package com.signette.controllers;

import java.util.Collection;

import javax.validation.Valid;

import com.signette.domains.Address;
import com.signette.domains.ERole;
import com.signette.domains.Role;
import com.signette.domains.User;
import com.signette.security.auth.jwt.JwtUtils;
import com.signette.security.auth.payload.request.LoginRequest;
import com.signette.security.auth.payload.request.SignupRequest;
import com.signette.security.auth.payload.response.JwtResponse;
import com.signette.security.auth.payload.response.MessageResponse;
import com.signette.service.AddressService;
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
import org.springframework.web.bind.annotation.*;


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
    AddressService addressService;

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

        if (userService.existsByUserMail(signUpRequest.getMail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getUserDateOfBirth(),
                signUpRequest.getUserEntryDate(),
                signUpRequest.getUserLastname(),
                signUpRequest.getMail(),
                signUpRequest.getUserName(),
                signUpRequest.getUserNss(),
                Encrypt.encoder().encode(signUpRequest.getPassword()),
                signUpRequest.getUserPhone(),
                signUpRequest.getUserUsername()
        );

        long idRoles = signUpRequest.getRoleId();
        Role roles = new Role();

        long idAddress = signUpRequest.getAddressId();
        Address address = addressService.findById(idAddress);

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

        user.setRole(roles);
        user.setAddress(address);
        userService.add(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }
}