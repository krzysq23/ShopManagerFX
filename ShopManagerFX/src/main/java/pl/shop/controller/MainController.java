package pl.shop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import pl.shop.model.Product;
import pl.shop.service.StageManager;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        System.out.println("Wylogowywanie...");
        StageManager.getInstance().loadScene("login");
    }

    @FXML
    public void handleProductListClick(ActionEvent actionEvent) {
        loadView("products");
    }

    @FXML
    public void handleAddProductClick(ActionEvent actionEvent) {
        loadView("addProduct");
    }

    @FXML
    public void handleSettingsClick(ActionEvent actionEvent) {
        loadView("settings");
    }

    @FXML
    public void handleProfileClick(ActionEvent actionEvent) {
        loadView("settings");
    }

    private void loadView(String name) {
        Parent view = StageManager.getInstance().getParent(name);
        contentPane.getChildren().setAll(view);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);
    }
}
