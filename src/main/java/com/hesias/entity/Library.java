package com.hesias.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Une bibliothèque peut avoir plusieurs livres
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    // Constructeur vide obligatoire pour JPA
    public Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    // Méthode simple pour ajouter un livre dans la bibliothèque
    public void addBook(Book book) {
        books.add(book);
        book.setLibrary(this);
    }

    // Méthode pour retirer un livre si besoin
    public void removeBook(Book book) {
        books.remove(book);
        book.setLibrary(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{id=" + id + ", name='" + name + "'}";
    }
}