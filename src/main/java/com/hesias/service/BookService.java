package com.hesias.service;

import com.hesias.entity.Book;
import com.hesias.entity.Library;
import com.hesias.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Injection du repository, Spring s'en occupe
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Ajouter un livre simple
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Ajouter un livre dans une bibliothèque
    public Book saveBookInLibrary(Book book, Library library) {
        library.addBook(book);
        return bookRepository.save(book);
    }

    // Récupérer tous les livres
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Récupérer un livre avec son id
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Récupérer les livres d'une bibliothèque avec son id
    public Optional<List<Book>> getBooksByLibraryId(Long libraryId) {
        return bookRepository.findAllByLibrary_Id(libraryId);
    }

    // Supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}