package za.co.protogen.core;

import za.co.protogen.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> getAllUsers();
    void updateUser(long id, User updatedUser);
    List<User> searchUsers(String firstName, String lastName, String rsaId);
}
