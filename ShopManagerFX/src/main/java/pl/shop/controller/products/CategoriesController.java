package pl.shop.controller.products;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.model.Category;

public class CategoriesController {

    @FXML
    private TableView<Category> categoriesTable;
    @FXML
    private TableColumn<Category, Integer> colId;
    @FXML
    private TableColumn<Category, String> colName;
    @FXML
    private TextField searchCategoryField;

    public void initialize() {

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        categoriesTable.setItems(MockCategoryDatabase.getAllCategories());

        searchCategoryField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie kategorii: " + lowerCaseFilter);
            categoriesTable.setItems(MockCategoryDatabase.search(lowerCaseFilter));
        });
    }
}
