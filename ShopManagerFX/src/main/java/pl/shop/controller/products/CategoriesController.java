package pl.shop.controller.products;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.model.Category;
import pl.shop.service.AlertService;
import pl.shop.service.StageManager;

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

        searchCategoryField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie kategorii: " + lowerCaseFilter);
            categoriesTable.setItems(MockCategoryDatabase.search(lowerCaseFilter));
        });
    }

    @FXML
    private void addCategoryButton(ActionEvent event) throws IOException {
        StageManager.getInstance().loadModal("category_modal", "Dodawanie kategorii", 400, 250);
    }

    @FXML
    private void editCategoryButton(ActionEvent event) throws IOException {
        Category selectedCategory = categoriesTable.getSelectionModel().getSelectedItem();
        if (selectedCategory != null) {
            StageManager.getInstance().loadModal("category_modal", "Edycja kategorii", 400, 250, selectedCategory);
        }
    }

    @FXML
    private void removeCategoryButton(ActionEvent event) throws IOException {
        Category selectedCategory = categoriesTable.getSelectionModel().getSelectedItem();
        if (selectedCategory != null) {
            System.out.println("Wybrano produkt: " + selectedCategory.getName());
            if(AlertService.confirm("Usuwanie kategorii", "Czy na pewno chcesz usunąć kategorię " + selectedCategory.getName() + "?")) {
                MockCategoryDatabase.remove(selectedCategory);
            }
        }
    }

}
