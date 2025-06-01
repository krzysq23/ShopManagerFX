package pl.shop.controller.settings;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import pl.shop.model.AppTheme;
import pl.shop.service.StageManager;

public class SettingsController {

    @FXML
    private ChoiceBox<String> languageChoiceBox;
    @FXML
    private ChoiceBox<String> dateFormatChoiceBox;
    @FXML
    private TextField minStockField;
    @FXML
    private ChoiceBox<String> unitChoiceBox;
    @FXML
    private ChoiceBox<String> exportFormatChoiceBox;
    @FXML
    private TextField exportPathField;
    @FXML
    private ChoiceBox<AppTheme> themeChoiceBox;

    @FXML
    public void initialize() {
        languageChoiceBox.getSelectionModel().selectFirst();
        dateFormatChoiceBox.getSelectionModel().selectFirst();
        minStockField.setTextFormatter(new TextFormatter<>(change ->
                change.getControlNewText().matches("\\d*") ? change : null
        ));
        minStockField.setText("5");
        unitChoiceBox.getSelectionModel().selectFirst();
        exportFormatChoiceBox.getSelectionModel().selectFirst();
        exportPathField.setText("/documents");

        themeChoiceBox.setItems(FXCollections.observableArrayList(AppTheme.values()));
        themeChoiceBox.getSelectionModel().select(StageManager.getInstance().getTheme());

        languageChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Wybrano język: " + newVal);
        });

        themeChoiceBox.setOnAction(event -> toggleTheme());
    }

    private void toggleTheme() {
        StageManager.getInstance().setTheme(themeChoiceBox.getValue());
    }

    public void handleSaveExportSettings(ActionEvent actionEvent) {
    }

    public void handleChangePassword(ActionEvent actionEvent) {
    }

    public void handleSaveWarehouseSettings(ActionEvent actionEvent) {

    }
}
