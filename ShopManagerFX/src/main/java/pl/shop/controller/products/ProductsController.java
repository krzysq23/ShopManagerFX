package pl.shop.controller.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockProductDatabase;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.Product;

import java.io.IOException;

public class ProductsController {

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
    @FXML
    private TextField searchProductField;

    public void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        colPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        tableView.setItems(MockProductDatabase.getAllProducts());

        searchProductField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie produktu: " + lowerCaseFilter);
            tableView.setItems(MockProductDatabase.search(lowerCaseFilter));
        });
    }

}
