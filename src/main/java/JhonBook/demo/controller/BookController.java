package JhonBook.demo.controller;


import JhonBook.demo.model.Book;
import JhonBook.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        var newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
}
