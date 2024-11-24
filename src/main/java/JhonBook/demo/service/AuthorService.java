package JhonBook.demo.service;

import JhonBook.demo.model.Author;
import JhonBook.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Método para criar um autor
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Método para listar todos os autores
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Método para buscar um autor por ID
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }


}


