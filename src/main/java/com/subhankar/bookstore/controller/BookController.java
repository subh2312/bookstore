package com.subhankar.bookstore.controller;

import com.subhankar.bookstore.dto.BookDto;
import com.subhankar.bookstore.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Book Api", tags = "Book Api", produces = "application.json")
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value="Get List of Books", response = BookDto[].class, produces = "application.json")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Success"),
            @ApiResponse(code=403, message = "Forbidden"),
            @ApiResponse(code=404, message = "Not Found")
    })
    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> bookDtoList = bookService.getBooks();

        return ResponseEntity.ok(bookDtoList);
    }
}
