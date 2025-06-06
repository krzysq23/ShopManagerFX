package pl.shop.mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.shop.model.User;
import pl.shop.model.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MockUsersDatabase {

    private static int increment = 4;
    private static final ObservableList<User> users = FXCollections.observableArrayList(
            new User(1, "admin", "admin", FXCollections.observableArrayList(UserRole.ADMIN)),
            new User(2, "user", "user", FXCollections.observableArrayList(UserRole.USER)),
            new User(3, "test", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(4, "kowalski", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(5, "nowak", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(6, "janek", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(7, "tadek", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(8, "zenek", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(9, "janusz", "1234", FXCollections.observableArrayList(UserRole.USER)),
            new User(10, "maciek", "1234", FXCollections.observableArrayList(UserRole.USER))
    );;
    private static final Map<Integer, User> usersMap = users.stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));

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

    public static User findById(int userId) {
        return usersMap.get(userId);
    }

    public static void add(User user) {
        user.idProperty().set(getIncrement());
        users.add(user);
    }

    public static void edit(User user) {
        User u = users.stream()
                .filter(prod -> prod.getId() == user.getId())
                .findFirst()
                .orElse(null);
        if (u != null) {
            u.loginProperty().set(user.getLogin());
            u.passwordProperty().set(user.getPassword());
            u.rolesProperty().set(user.getRoles());
        }
    }

    public static void remove(User user) {
        users.remove(user);
    }

    public static int getIncrement() {
        return increment++;
    }

}
