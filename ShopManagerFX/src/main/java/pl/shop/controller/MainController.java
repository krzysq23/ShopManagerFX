package pl.shop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import pl.shop.service.StageManager;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentPane;
    @FXML
    private MenuButton userMenuButton;

    private String activeView = "";

    public void initialize() {
        loadView("home");
        userMenuButton.setText(StageManager.getInstance().getUserName());
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        System.out.println("Wylogowywanie...");
        StageManager.getInstance().loadScene("login");
    }

    @FXML
    private void openSearchWindow(ActionEvent event) throws IOException {
        StageManager.getInstance().loadModal("search_modal", "Wyszukiwanie", 300, 150);
    }

    @FXML
    private void handleHomeClick(ActionEvent event) throws IOException {
        loadView("home");
        this.activeView = "home";
    }

    @FXML
    public void handleProductClick(ActionEvent actionEvent) {
        loadView("products");
        this.activeView = "products";
    }

    @FXML
    public void handleCategoryClick(ActionEvent actionEvent) {
        loadView("categories");
        this.activeView = "categories";
    }

    @FXML
    public void handleOrdersClick(ActionEvent actionEvent) {
        loadView("orders");
        this.activeView = "orders";
    }

    @FXML
    public void handleUsersClick(ActionEvent actionEvent) {
        loadView("users");
        this.activeView = "users";
    }

    @FXML
    public void handleSettingsClick(ActionEvent actionEvent) {
        loadView("settings");
        this.activeView = "settings";
    }


    private void loadView(String name) {
        if(!this.activeView.equals(name)) {
            Parent view = StageManager.getInstance().getParent(name);
            contentPane.getChildren().setAll(view);
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
        }
    }
}
