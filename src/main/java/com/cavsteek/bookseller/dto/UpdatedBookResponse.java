package com.cavsteek.bookseller.dto;

import com.cavsteek.bookseller.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UpdatedBookResponse {
    private String message;
    private Book book;
}