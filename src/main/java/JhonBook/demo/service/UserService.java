package JhonBook.demo.service;

import JhonBook.demo.model.User;
import JhonBook.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Construtor para injeção de dependência
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Salvar o usuário no banco
        return userRepository.save(user);
    }
}
