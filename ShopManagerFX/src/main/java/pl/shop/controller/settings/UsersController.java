package pl.shop.controller.settings;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.User;
import pl.shop.model.UserRole;

import java.io.IOException;

public class UsersController {

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colLogin;
    @FXML
    private TableColumn<User, String> colPassword;
    @FXML
    private TableColumn<User, String> colRole;
    @FXML
    private TextField searchUserField;

    public void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colLogin.setCellValueFactory(cellData -> cellData.getValue().loginProperty());
        colPassword.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        colRole.setCellValueFactory(cellData -> {
            ObservableList<UserRole> roles = cellData.getValue().rolesProperty();
            String rolesString = roles.stream()
                    .map(UserRole::toString) // lub getName()
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            return new SimpleStringProperty(rolesString);
        });
        userTable.setItems(MockUsersDatabase.getAllUsers());

        searchUserField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie użytkownika: " + lowerCaseFilter);
            userTable.setItems(MockUsersDatabase.search(lowerCaseFilter));
        });
    }

}
