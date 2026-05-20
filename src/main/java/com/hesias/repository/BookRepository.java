package com.hesias.repository;

import com.hesias.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Permet de chercher tous les livres qui appartiennent à une bibliothèque
    Optional<List<Book>> findAllByLibrary_Id(Long libraryId);
}