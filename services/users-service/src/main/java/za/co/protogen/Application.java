
package za.co.protogen;

import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Adding users
        User user1 = new User(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "1234567890123");
        User user2 = new User(2L, "Jane", "Smith", LocalDate.of(1985, 6, 15), "9876543210987");

        userService.addUser(user1);
        userService.addUser(user2);

        // Retrieving users
        System.out.println("All Users:");
        List<User> allUsers = userService.getAllUsers();
        displayUserInformation(allUsers);

        // Get user by ID
        System.out.println("\nUser with ID 1:");
        User userById = userService.getUserById(1);
        if (userById != null) {
            displayUserInformation(List.of(userById));
        } else {
            System.out.println("User not found.");
        }

        // Removing a user
        userService.removeUser(2);

        // Retrieving users after removal
        System.out.println("\nAll Users after removal:");
        allUsers = userService.getAllUsers();
        displayUserInformation(allUsers);
    }

    // method to display user information
    public static void displayUserInformation(List<User> users) {
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Date of Birth: " + user.getDateOfBirth());
            System.out.println("RSA ID: " + user.getRsaId());
            System.out.println();
        }
    }
}
