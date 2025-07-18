package kg.attractor.movie_review2549.controller;

import kg.attractor.movie_review2549.model.User;
import kg.attractor.movie_review2549.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUseById(id);
    }

    @GetMapping("username/{usernsme}")
    public List<User> getUsersByUsername(@PathVariable String usernsme) {
        return userService.findByUsername(usernsme);
    }

    @PostMapping
    public User createUser(@RequestBody User user) { // User вместо int
        return userService.createUser(user);
    }
}
