package com.cavsteek.bookseller.service.impl;

import com.cavsteek.bookseller.model.Book;
import com.cavsteek.bookseller.repository.BookRepository;
import com.cavsteek.bookseller.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book){
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }

    @Override
    public boolean bookExists(String title, String description, String author, Double price){
        return bookRepository.existsByTitleAndDescriptionAndAuthorAndPrice(title, description, author, price);
    }

    @Override
    public void updateBook(Book book, Long id)
    {
        Optional<Book> book_ = bookRepository.findById(id);
        if (book_.isPresent()) {
            Book existingBook = book_.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setDescription(book.getDescription());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());

            bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    @Override
    public Book updateTitle(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        book.setTitle(book.getTitle());

        Book updatedTitle = bookRepository.save(book);

        return mapToBook(updatedTitle);
    }

    private Book mapToBook (Book book){
        Book book_ = new Book();
        book_.setTitle(book.getTitle());
        book_.setDescription(book.getDescription());
        book_.setAuthor(book.getAuthor());
        book_.setPrice(book.getPrice());

        return book_;
    }

}
