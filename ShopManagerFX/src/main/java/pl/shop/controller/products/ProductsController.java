package pl.shop.controller.products;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.shop.model.Product;

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
}
