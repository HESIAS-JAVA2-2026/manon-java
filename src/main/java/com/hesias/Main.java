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

        // Je crée des livres
        Book book1 = new Book("Clean Code");
        Book book2 = new Book("Effective Java");
        Book book3 = new Book("Spring Boot");

        // J'ajoute les livres dans la bibliothèque grâce à son id
        libraryService.addBookToLibrary(book1, library.getId());
        libraryService.addBookToLibrary(book2, library.getId());
        libraryService.addBookToLibrary(book3, library.getId());

        // J'affiche toutes les bibliothèques
        System.out.println("=== Toutes les bibliothèques ===");
        System.out.println(libraryService.getAllLibraries());

        // J'affiche tous les livres
        System.out.println("=== Tous les livres ===");
        System.out.println(bookService.getAllBooks());

        // Je cherche une bibliothèque par son nom
        System.out.println("=== Recherche d'une bibliothèque par nom ===");
        System.out.println(libraryService.getLibraryByName("City Library"));

        // Je cherche une bibliothèque par son id
        System.out.println("=== Recherche d'une bibliothèque par id ===");
        System.out.println(libraryService.getLibraryById(library.getId()));

        // Je cherche un livre par son id
        System.out.println("=== Recherche d'un livre par id ===");
        System.out.println(bookService.getBookById(book1.getId()));

        // Je récupère tous les livres d'une bibliothèque
        System.out.println("=== Livres de la bibliothèque ===");
        System.out.println(libraryService.getBooksByLibrary(library.getId()));

        // Je retire un livre de la bibliothèque
        libraryService.removeBookFromLibrary(book2.getId(), library.getId());

        System.out.println("=== Livres après retrait d'un livre de la bibliothèque ===");
        System.out.println(libraryService.getBooksByLibrary(library.getId()));

        // Je supprime vraiment le livre de la base
        bookService.deleteBook(book2.getId());

        System.out.println("=== Tous les livres après suppression ===");
        System.out.println(bookService.getAllBooks());
    }
}