package com.hesias.repository;

import com.hesias.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Je récupère tous les livres d'une bibliothèque
    List<Book> findAllByLibrary_Id(Long libraryId);
}