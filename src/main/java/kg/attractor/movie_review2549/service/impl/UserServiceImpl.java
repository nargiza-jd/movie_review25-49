package kg.attractor.movie_review2549.service.impl;

import kg.attractor.movie_review2549.dao.UserDao;
import kg.attractor.movie_review2549.dto.UserDto;
import kg.attractor.movie_review2549.exceptions.UserNotFoundException;
import kg.attractor.movie_review2549.model.User;
import kg.attractor.movie_review2549.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder encoder;

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User createUser(UserDto user) {
//        int newUserId = userDao.addUser(user);
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        return newUser;
    }
}