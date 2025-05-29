package pl.shop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.shop.model.Product;
import pl.shop.service.StageManager;

import java.io.IOException;

public class MainController {

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Integer> colId;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, Integer> colQuantity;
    @FXML
    private TableColumn<Product, Double> colPrice;

    public void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        colPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        ObservableList<Product> products = FXCollections.observableArrayList(
                new Product(1, "Mleko", 10, 2.5),
                new Product(2, "Chleb", 5, 3.0),
                new Product(3, "Masło", 7, 4.2)
        );
        tableView.setItems(products);
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        System.out.println("Wylogowywanie...");
        StageManager.getInstance().loadScene("login");
    }

    @FXML
    public void handleBtn1Click(ActionEvent actionEvent) {
        
    }

    @FXML
    public void handleBtn2Click(ActionEvent actionEvent) {
    }

    @FXML
    public void handleBtn3Click(ActionEvent actionEvent) {

    }
}
