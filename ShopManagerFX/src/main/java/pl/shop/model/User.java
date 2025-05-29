package pl.shop.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class User {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty login;
    private final SimpleStringProperty password;
    private final SimpleListProperty<UserRole> roles;

    public User(int id, String login, String password, ObservableList<UserRole> roles) {
        this.id = new SimpleIntegerProperty(id);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
        this.roles = new SimpleListProperty<UserRole>(roles);
    }

    public int getId() { return id.get(); }
    public String getLogin() { return login.get(); }
    public String getPassword() { return password.get(); }
    public ObservableList<UserRole> getRoles() { return roles.get(); }

    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleStringProperty loginProperty() { return login; }
    public SimpleStringProperty passwordProperty() { return password; }
    public SimpleListProperty<UserRole> rolesProperty() { return roles; }

}
