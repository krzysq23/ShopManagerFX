package pl.shop.controller.modals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import pl.shop.mock.MockCategoryDatabase;
import pl.shop.mock.MockProductDatabase;
import pl.shop.model.Category;
import pl.shop.model.Product;
import pl.shop.util.ParamReceiver;
import pl.shop.util.ValidatorUtil;

public class ProductModalController implements ParamReceiver {

    @FXML
    private TextField productId;
    @FXML
    private TextField nameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;
    @FXML
    private ComboBox<Category> categoryComboBox;

    private final ValidatorUtil validator = ValidatorUtil.getInstance();

    @Override
    public void receiveParams(Object... params) {
        Product product = (Product) params[0];
        productId.setText(String.valueOf(product.getId()));
        nameField.setText(product.getName());
        quantityField.setText(String.valueOf(product.getQuantity()));
        priceField.setText(String.valueOf(product.getPrice()));
        categoryComboBox.setValue(MockCategoryDatabase.findById(product.getCategory()));
    }

    public void initialize() {

        quantityField.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().matches("\\d*") ? change : null
        ));
        priceField.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().matches("\\d*(\\.\\d*)?") ? change : null
        ));
        categoryComboBox.setItems(MockCategoryDatabase.getAllCategories());

    }

    @FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        if (validator.validField(nameField)
                && validator.validField(quantityField)
                && validator.validField(priceField)
                && validator.validCombo(categoryComboBox)) {
            Product product = new Product(0,
                    nameField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    Double.parseDouble(priceField.getText()),
                    categoryComboBox.getValue().getId()
            );
            if(productId.getText().isEmpty()) {
                MockProductDatabase.add(product);
                System.out.println("Zapisano: " + product);
            } else {
                product.idProperty().set(Integer.parseInt(productId.getText()));
                MockProductDatabase.edit(product);
                System.out.println("Edytowano: " + product);
            }
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
