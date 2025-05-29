package pl.shop.controller.products;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.mock.MockProductDatabase;
import pl.shop.model.Category;

import java.io.IOException;

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
    }

    @FXML
    private void searchCategoryButton(ActionEvent event) throws IOException {
        String query = searchCategoryField.getText();
        System.out.println("Wyszukiwanie: " + query);
        categoriesTable.setItems(MockCategoryDatabase.search(query));
    }
}
