package pl.shop.controller.settings;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.User;
import pl.shop.model.UserRole;
import pl.shop.service.AlertService;
import pl.shop.service.StageManager;

import java.io.IOException;
import java.util.stream.Collectors;

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
        colPassword.setCellValueFactory(cellData -> new SimpleStringProperty("*".repeat(cellData.getValue().getPassword().length())));
        colRole.setCellValueFactory(cellData -> {
            SimpleListProperty<UserRole> rolesProp = cellData.getValue().rolesProperty();
            return Bindings.createStringBinding(
                    () -> rolesProp.stream()
                            .map(UserRole::name)
                            .collect(Collectors.joining(", ")),
                    rolesProp
            );
        });
        userTable.setItems(MockUsersDatabase.getAllUsers());

        searchUserField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie użytkownika: " + lowerCaseFilter);
            userTable.setItems(MockUsersDatabase.search(lowerCaseFilter));
        });
    }

    @FXML
    private void addUserButton(ActionEvent event) throws IOException {
        StageManager.getInstance().loadModal("user_modal", "Dodawanie użytkownika", 400, 300);
    }

    @FXML
    private void editUserButton(ActionEvent event) throws IOException {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            StageManager.getInstance().loadModal("user_modal", "Edycja użytkownika", 400, 300, selectedUser);
        }
    }

    @FXML
    private void removeUserButton(ActionEvent event) throws IOException {
        User selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            System.out.println("Usunięto użytkownika: " + selectedUser.getLogin());
            if(AlertService.confirm("Usuwanie produktu", "Czy na pewno chcesz usunąć użytkownika " + selectedUser.getLogin() + "?")) {
                MockUsersDatabase.remove(selectedUser);
            }
        }
    }

}
