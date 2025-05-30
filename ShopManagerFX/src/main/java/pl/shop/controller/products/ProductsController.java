package pl.shop.controller.products;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.mock.MockProductDatabase;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.Category;
import pl.shop.model.Product;
import pl.shop.model.UserRole;
import pl.shop.service.AlertService;
import pl.shop.service.StageManager;

import java.io.IOException;

public class ProductsController {

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> colId;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, Integer> colQuantity;
    @FXML
    private TableColumn<Product, Double> colPrice;
    @FXML
    private TableColumn<Product, String> colCategory;
    @FXML
    private TextField searchProductField;

    public void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colQuantity.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        colPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        colCategory.setCellValueFactory(cellData -> {
            IntegerProperty categoryIdProp = cellData.getValue().categoryProperty();
            return Bindings.createStringBinding(
                    () -> {
                        return MockCategoryDatabase.findById(categoryIdProp.get()).getName();
                    },
                    categoryIdProp
            );
        });

        productTable.setItems(MockProductDatabase.getAllProducts());

        searchProductField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            productTable.setItems(MockProductDatabase.search(lowerCaseFilter));
        });
    }

    @FXML
    private void addProductButton(ActionEvent event) throws IOException {
        StageManager.getInstance().loadModal("product_modal", "Dodawanie produktu", 400, 300);
    }

    @FXML
    private void editProductButton(ActionEvent event) throws IOException {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            StageManager.getInstance().loadModal("product_modal", "Edycja produktu", 400, 300, selectedProduct);
        }
    }

    @FXML
    private void removeProductButton(ActionEvent event) throws IOException {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            System.out.println("Wybrano produkt: " + selectedProduct.getName());
            if(AlertService.confirm("Usuwanie produktu", "Czy na pewno chcesz usunąć produkt " + selectedProduct.getName() + "?")) {
                MockProductDatabase.remove(selectedProduct);
            }
        }
    }

}
