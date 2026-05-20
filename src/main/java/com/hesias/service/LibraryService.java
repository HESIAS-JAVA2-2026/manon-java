package com.hesias.service;

import com.hesias.entity.Library;
import com.hesias.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    // Injection du repository
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
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

    // Supprimer une bibliothèque
    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }
}