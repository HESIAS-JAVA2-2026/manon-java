package com.hesias.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Un livre appartient à une bibliothèque
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    // Constructeur vide obligatoire pour JPA
    public Book() {
    }

    // Constructeur pratique pour créer un livre plus vite
    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Library getLibrary() {
        return library;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        String libraryName = "pas de bibliothèque";

        if (library != null) {
            libraryName = library.getName();
        }

        return "Book{id=" + id + ", title='" + title + "', library='" + libraryName + "'}";
    }
}