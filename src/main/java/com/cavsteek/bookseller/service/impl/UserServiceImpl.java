package com.cavsteek.bookseller.service.impl;

import com.cavsteek.bookseller.model.Role;
import com.cavsteek.bookseller.model.User;
import com.cavsteek.bookseller.repository.UserRepository;
import com.cavsteek.bookseller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return email -> userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<User> findUsersByRole() {
        return userRepository.findAllUsersByRole(Role.USER);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
