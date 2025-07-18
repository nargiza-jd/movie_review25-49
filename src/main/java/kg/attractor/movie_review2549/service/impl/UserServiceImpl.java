package kg.attractor.movie_review2549.service.impl;

import kg.attractor.movie_review2549.dao.UserDao;
import kg.attractor.movie_review2549.exceptions.UserNotFoundException;
import kg.attractor.movie_review2549.model.User;
import kg.attractor.movie_review2549.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUseById(int id) {
        return userDao.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userDao.getByUsername(username);
    }

//    @Override
//    public int createUser(User user) {
//        return userDao.addUser(user);
//    }

    // вдруг мы хотим воспользоваться int newUserId

    @Override
    public User createUser(User user) {
        int newUserId = userDao.addUser(user);
        return getUseById(newUserId);
    }
}
