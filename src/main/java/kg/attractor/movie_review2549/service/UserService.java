package kg.attractor.movie_review2549.service;

import kg.attractor.movie_review2549.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUseById(int id);

    List<User> findByUsername(String username);

    User createUser(User user);
}
