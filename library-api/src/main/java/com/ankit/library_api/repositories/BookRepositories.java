package com.ankit.library_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.library_api.entities.Book;

public interface BookRepositories extends JpaRepository<Book, Integer> {

}
