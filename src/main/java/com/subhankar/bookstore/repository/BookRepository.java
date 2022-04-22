package com.subhankar.bookstore.repository;

import com.subhankar.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findBookByTitle(String title);
}
