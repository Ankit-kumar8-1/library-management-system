package com.ankit.library_api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ankit.library_api.entities.Book;
import com.ankit.library_api.repositories.BookRepositories;

@Service
public class BookService {

    private final BookRepositories bookRepositories;

    public BookService(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;

    }

    // Add book
    public Book saveOrUpdateBook(Book book) {
        validation(book);
        if (book.getId() != 0 && bookRepositories.existsById(book.getId())) {
            Book exitsingBook = bookRepositories.findById(book.getId()).get();
            exitsingBook.setTitle(book.getTitle());
            exitsingBook.setAuthor(book.getAuthor());
            exitsingBook.setPrice(book.getPrice());

            return bookRepositories.save(exitsingBook);
        } else {
            return bookRepositories.save(book);
        }
    }

    // Get book
    public List<Book> getAllBooks() {
        return bookRepositories.findAll();
    }

    // Get book by Id
    public Book getBookById(int id) {
        return bookRepositories.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    // Delete book

    public void deleteBook(int id) {
        bookRepositories.deleteById(id);
    }

    // validation book add check like null isEmpty
    public void validation(Book book) {
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author  cannot be empty");
        }

        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Tiltle cannot be empty");
        }
        if (book.getPrice() <= 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(String title) {
        return bookRepositories.findAll().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

}
