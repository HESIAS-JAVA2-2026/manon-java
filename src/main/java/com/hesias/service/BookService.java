package com.hesias.service;

import com.hesias.entity.Book;
import com.hesias.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Spring donne automatiquement le repository ici
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Ajouter un livre
    public Book saveBook(Book book) {
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

    // Récupérer tous les livres d'une bibliothèque avec l'id de la bibliothèque
    public List<Book> getBooksByLibraryId(Long libraryId) {
        return bookRepository.findAllByLibrary_Id(libraryId);
    }

    // Supprimer un livre
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}