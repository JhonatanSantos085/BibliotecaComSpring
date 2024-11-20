package JhonBook.demo.service;

import JhonBook.demo.model.User;
import JhonBook.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

}
