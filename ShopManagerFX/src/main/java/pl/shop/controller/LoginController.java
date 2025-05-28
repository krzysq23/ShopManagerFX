package pl.shop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        if ("admin".equals(login) && "admin".equals(password)) {
            StageManager.getInstance().loadScene("main");
        } else {
            showAlert(Alert.AlertType.ERROR, "Błąd", "Nieprawidłowy login lub hasło.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
