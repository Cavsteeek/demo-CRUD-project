package com.cavsteek.bookseller.service;


import com.cavsteek.bookseller.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

//    Optional<User> findByEmail(String email);


    List<User> findUsersByRole();

//    boolean emailExists(String email);

    boolean usernameExists(String email);

    void deleteUser(Long id);
}
