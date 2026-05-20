package com.hesias;

import com.hesias.entity.Book;
import com.hesias.entity.Library;
import com.hesias.service.BookService;
import com.hesias.service.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final BookService bookService;
    private final LibraryService libraryService;

    public Main(BookService bookService, LibraryService libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        // Je crée une bibliothèque
        Library library = new Library("City Library");
        libraryService.saveLibrary(library);

        // Je crée deux livres
        Book book1 = new Book("Clean Code");
        Book book2 = new Book("Effective Java");

        // Je les ajoute dans la bibliothèque
        bookService.saveBookInLibrary(book1, library);
        bookService.saveBookInLibrary(book2, library);

        // J'affiche toutes les bibliothèques
        System.out.println("=== Toutes les bibliothèques ===");
        System.out.println(libraryService.getAllLibraries());

        // J'affiche tous les livres
        System.out.println("=== Tous les livres ===");
        System.out.println(bookService.getAllBooks());

        // Je cherche une bibliothèque par son nom
        System.out.println("=== Recherche bibliothèque par nom ===");
        System.out.println(libraryService.getLibraryByName("City Library"));

        // Je cherche un livre par son id
        System.out.println("=== Recherche livre par id ===");
        System.out.println(bookService.getBookById(book1.getId()));

        // Je supprime un livre pour montrer que la méthode marche
        bookService.deleteBook(book2.getId());

        // Je réaffiche les livres après suppression
        System.out.println("=== Livres après suppression ===");
        System.out.println(bookService.getAllBooks());
    }
}