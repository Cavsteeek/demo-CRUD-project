package com.cavsteek.bookseller.service;


import com.cavsteek.bookseller.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findUsersByRole();

    boolean emailExists(String email);

    void deleteUser(Long id);
}
