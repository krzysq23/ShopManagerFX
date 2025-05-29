package pl.shop.controller.modals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchModalController {

    @FXML
    private TextField searchField;

    @FXML
    public void searchActionButton(ActionEvent actionEvent) {

        String query = searchField.getText();
        System.out.println("Wyszukiwanie: " + query);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
