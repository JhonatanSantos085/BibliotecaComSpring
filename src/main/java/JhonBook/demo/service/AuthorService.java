package JhonBook.demo.service;

import JhonBook.demo.model.Author;
import JhonBook.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }


}


