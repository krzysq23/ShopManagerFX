package pl.shop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        Stage searchStage = new Stage();
        searchStage.initModality(Modality.APPLICATION_MODAL);
        searchStage.setResizable(false);
        searchStage.setTitle("Wyszukiwanie");

        Label prompt = new Label("Wpisz czego szukasz:");
        TextField searchField = new TextField();
        Button searchActionButton = new Button("Szukaj");

        searchActionButton.setOnAction(e -> {
            String query = searchField.getText();
            System.out.println("Wyszukiwanie: " + query);
            searchStage.close();
        });

        VBox layout = new VBox(10, prompt, searchField, searchActionButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 300, 150);
        searchStage.setScene(scene);
        searchStage.showAndWait();
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
