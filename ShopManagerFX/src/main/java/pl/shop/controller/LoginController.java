package pl.shop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.service.AlertService;
import pl.shop.service.StageManager;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (MockUsersDatabase.authenticate(login, password)) {
            StageManager.getInstance().setUserName(login);
            StageManager.getInstance().loadScene("main");
        } else {
            AlertService.show(Alert.AlertType.ERROR, "Błąd", "Nieprawidłowy login lub hasło.");
        }
    }

}
