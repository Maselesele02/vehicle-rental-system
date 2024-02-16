
package za.co.protogen.core.impl;

import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }

    @Override
    public void removeUser(long id) {
        Constant.users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User getUserById(long id) {
        return Constant.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(Constant.users);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User userToUpdate = getUserById(id);
        if (userToUpdate != null) {
            userToUpdate.setFirstName(updatedUser.getFirstName());
            userToUpdate.setLastName(updatedUser.getLastName());
            userToUpdate.setDateOfBirth(updatedUser.getDateOfBirth());
            userToUpdate.setRsaId(updatedUser.getRsaId());
        }
    }

    @Override
    public List<User> searchUsers(String firstName, String lastName, String rsaId) {
        return Constant.users.stream()
                .filter(user -> (firstName == null || user.getFirstName().equalsIgnoreCase(firstName)) &&
                        (lastName == null || user.getLastName().equalsIgnoreCase(lastName)) &&
                        (rsaId == null || user.getRsaId().equals(rsaId)))
                .collect(Collectors.toList());
    }
}
