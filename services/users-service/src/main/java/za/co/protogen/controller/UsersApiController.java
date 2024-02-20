package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersApiController {

    // Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return Constant.getUsers();
    }

    // Retrieve a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return Constant.getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Add a new user
    @PostMapping
    public void addUser(@RequestBody User user) {
        Constant.getUsers().add(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User updatedUser) {
        List<User> users = Constant.getUsers();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId() == id) {
                users.set(i, updatedUser);
                return;
            }
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        Constant.getUsers().removeIf(user -> user.getId() == id);
    }
}
