package com.cavsteek.bookseller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private String role;
    private String email;
    private String refreshToken;
    private Long userId;
}
