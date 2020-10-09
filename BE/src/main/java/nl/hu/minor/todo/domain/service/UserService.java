package nl.hu.minor.todo.domain.service;

import lombok.RequiredArgsConstructor;
import nl.hu.minor.todo.data.entity.User;
import nl.hu.minor.todo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User userToSave) {
        return userRepository.save(userToSave);
    }
    public List<User> findallusers() {
        return userRepository.findAll();
    }
    public User findUser(UUID id) {
        return userRepository.getOne(id);
    }

    public User findByUname(String name) {
        return userRepository.findByUname(name);
    }
}
