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

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Método POST para criar um livro
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestParam Long authorId, @RequestBody Book book) {
        Book createdBook = bookService.createBook(authorId, book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // Método GET para listar todos os livros
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
}