package com.subhankar.bookstore.controller;

import com.subhankar.bookstore.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        BookDto bookDto = BookDto.builder().title("My First Book").build();
        List<BookDto> bookDtoList = new ArrayList<>();
        BookDto bookDto2 = BookDto.builder().title("My Second Book").build();
        BookDto bookDto3 = BookDto.builder().title("My Second Book").build();
        bookDtoList.add(bookDto);
        bookDtoList.add(bookDto2);
        bookDtoList.add(bookDto3);

        return ResponseEntity.ok(bookDtoList);
    }
}
