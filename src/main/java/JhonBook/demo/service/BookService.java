package JhonBook.demo.service;

import JhonBook.demo.model.Author;
import JhonBook.demo.model.Book;
import JhonBook.demo.repository.AuthorRepository;
import JhonBook.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(Long authorId, Book book) {
        // Busca o autor pelo ID
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Associa o autor ao livro
        book.setAuthor(author);

        // Salva o livro
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

