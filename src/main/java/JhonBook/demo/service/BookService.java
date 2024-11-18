package JhonBook.demo.service;

import JhonBook.demo.model.Book;
import JhonBook.demo.repository.BookRepository;
import org.springframework.stereotype.Service;




@Service
public class BookService {

    private BookRepository bookRepository;


    public Book createBook(Book book){
        return bookRepository.save(book);
    }
}
