package com.hesias.repository;

import com.hesias.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    // Spring comprend tout seul qu'il doit chercher avec le nom
    Library findByName(String name);
}