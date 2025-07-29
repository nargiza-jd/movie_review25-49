package kg.attractor.movie_review2549.service;

import kg.attractor.movie_review2549.dto.UserDto;
import kg.attractor.movie_review2549.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(int id);

    List<User> findByUsername(String username);

    User createUser(UserDto user);
}
