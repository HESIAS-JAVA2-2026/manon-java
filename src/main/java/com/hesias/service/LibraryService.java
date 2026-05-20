package com.hesias.service;

import com.hesias.entity.Book;
import com.hesias.entity.Library;
import com.hesias.repository.BookRepository;
import com.hesias.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;

    // Injection des repositories
    public LibraryService(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    // Ajouter une bibliothèque
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    // Récupérer toutes les bibliothèques
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    // Récupérer une bibliothèque avec son id
    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id).orElse(null);
    }

    // Récupérer une bibliothèque avec son nom
    public Library getLibraryByName(String name) {
        return libraryRepository.findByName(name);
    }

    // Récupérer tous les livres d'une bibliothèque avec son id
    public List<Book> getBooksByLibrary(Long libraryId) {
        return bookRepository.findAllByLibrary_Id(libraryId);
    }

    // Ajouter un livre dans une bibliothèque grâce à l'id de la bibliothèque
    public void addBookToLibrary(Book book, Long libraryId) {
        Library library = libraryRepository.findById(libraryId).orElse(null);

        if (library != null) {
            book.setLibrary(library);
            bookRepository.save(book);
        }
    }

    // Retirer un livre d'une bibliothèque grâce à l'id du livre et de la bibliothèque
    public void removeBookFromLibrary(Long bookId, Long libraryId) {
        Library library = libraryRepository.findById(libraryId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (library != null && book != null) {
            book.setLibrary(null);
            bookRepository.save(book);
        }
    }

    // Supprimer une bibliothèque
    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }
}