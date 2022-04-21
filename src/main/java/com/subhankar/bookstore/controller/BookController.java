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
        bookDtoList.add(bookDto);

        return ResponseEntity.ok(bookDtoList);
    }
}
