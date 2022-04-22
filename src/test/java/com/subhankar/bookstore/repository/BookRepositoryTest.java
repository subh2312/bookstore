package com.subhankar.bookstore.repository;

import com.subhankar.bookstore.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchAllBooksInDb(){

        Iterable<Book> all = bookRepository.findAll();
        Long totalBookCount = StreamSupport.stream(all.spliterator(),false).count();

        Assertions.assertEquals(2,totalBookCount);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchOneBookWhenTitleIsTestBook1(){

        List<Book> all = bookRepository.findBookByTitle("TestBook1");


        Assertions.assertEquals(1,all.size());
    }
}
