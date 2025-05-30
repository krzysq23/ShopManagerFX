package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.User;
import pl.shop.model.UserRole;

import java.util.List;
import java.util.stream.Collectors;

public class MockUsersDatabase {

    private static int increment = 4;

    public static ObservableList<User> getAllUsers() {
        return users;
    }

    public static ObservableList<User> search(String query) {
        List<User> filtered = users.stream()
                .filter(p -> p.getLogin().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(filtered);
    }

    public static boolean authenticate(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static int getIncrement() {
        return increment++;
    }

    private static final ObservableList<User> users = FXCollections.observableArrayList(
            new User(1, "admin", "admin", FXCollections.observableArrayList(UserRole.ADMIN)),
            new User(2, "user", "user", FXCollections.observableArrayList(UserRole.USER)),
            new User(3, "test", "1234", FXCollections.observableArrayList(UserRole.USER))
    );
}
