package pl.shop.controller.modals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.model.Category;
import pl.shop.util.ParamReceiver;
import pl.shop.util.ValidatorUtil;

public class CategoryModalController implements ParamReceiver {

    @FXML
    private TextField categoryId;
    @FXML
    private TextField nameField;

    private final ValidatorUtil validator = ValidatorUtil.getInstance();

    @Override
    public void receiveParams(Object... params) {
        Category product = (Category) params[0];
        categoryId.setText(String.valueOf(product.getId()));
        nameField.setText(product.getName());
    }

    public void initialize() {

    }

    @FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        if (validator.validField(nameField)) {
            Category category = new Category(0, nameField.getText());
            if(categoryId.getText().isEmpty()) {
                MockCategoryDatabase.add(category);
                System.out.println("Zapisano: " + category);
            } else {
                category.idProperty().set(Integer.parseInt(categoryId.getText()));
                MockCategoryDatabase.edit(category);
                System.out.println("Edytowano: " + category);
            }
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
