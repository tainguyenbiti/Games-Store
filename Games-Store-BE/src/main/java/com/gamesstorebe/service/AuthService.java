
package com.gamesstorebe.service;


import com.gamesstorebe.entity.Role;
import com.gamesstorebe.entity.User;
import com.gamesstorebe.repository.RoleRepository;
import com.gamesstorebe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<Object> registerUser(User user) {
        if (userRepository.findByEmail(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or password is empty");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        Role role = roleRepository.findByRole("USER").orElseThrow(() -> new RuntimeException("Role not found"));
        Set<Role> authorities = new HashSet<>();
        authorities.add(role);
        user.setUserRole(authorities);
        user.setStatus(true);
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return ResponseEntity.ok().body("Register successfully");
    }

    public ResponseEntity<Object> loginUser(String email, String password){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
                String token = tokenService.generateToken(auth);
                return ResponseEntity.ok().body(token);

        } catch (DisabledException e) {
            return ResponseEntity.status(401).body("Account has been disabled");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }
}

