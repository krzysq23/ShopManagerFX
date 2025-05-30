package pl.shop.controller.modals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.WorldMapView;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.User;
import pl.shop.model.UserRole;
import pl.shop.util.ParamReceiver;
import pl.shop.util.ValidatorUtil;

import java.util.Arrays;

public class UserModalController implements ParamReceiver {

    @FXML
    private TextField userId;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private CheckComboBox<UserRole> roleComboBox;

    private final ValidatorUtil validator = ValidatorUtil.getInstance();

    @Override
    public void receiveParams(Object... params) {
        User user = (User) params[0];
        userId.setText(String.valueOf(user.getId()));
        loginField.setText(user.getLogin());
        passwordField.setText(String.valueOf(user.getPassword()));
        user.getRoles().forEach(r ->
                roleComboBox.getCheckModel().check(UserRole.valueOf(r.name()))
        );
    }

    public void initialize() {

        ObservableList<UserRole> allRoles = FXCollections.observableArrayList(UserRole.values());
        roleComboBox.getItems().addAll(allRoles);
        roleComboBox.getCheckModel().check(UserRole.USER);
    }

    @FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        if (validator.validField(loginField)
                && validator.validField(passwordField)
                && validator.validCheckComboBox(roleComboBox)) {
            User user = new User(0,
                    loginField.getText(),
                    passwordField.getText(),
                    roleComboBox.getCheckModel().getCheckedItems()
            );
            if(userId.getText().isEmpty()) {
                MockUsersDatabase.add(user);
                System.out.println("Zapisano: " + user);
            } else {
                user.idProperty().set(Integer.parseInt(userId.getText()));
                MockUsersDatabase.edit(user);
                System.out.println("Edytowano: " + user);
            }
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
