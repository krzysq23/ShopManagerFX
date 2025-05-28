package pl.shop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.shop.service.StageManager;

import java.io.IOException;

public class MainController {

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        System.out.println("Wylogowywanie...");
        StageManager.getInstance().loadScene("login");
    }
}
