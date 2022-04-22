package com.subhankar.bookstore.service;

import com.subhankar.bookstore.dto.BookDto;
import com.subhankar.bookstore.model.Book;
import com.subhankar.bookstore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private BookRepository repository;
    private ModelMapper mapper;

    public BookService(BookRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BookDto> getBooks(){
        Iterable<Book> all = repository.findAll();
        return StreamSupport.stream(all.spliterator(),false).map(convertBookModelToBookDto()).collect(Collectors.toList());
    }

    private Function<Book, BookDto> convertBookModelToBookDto() {
        return book -> mapper.map(book, BookDto.class);
    }
}
