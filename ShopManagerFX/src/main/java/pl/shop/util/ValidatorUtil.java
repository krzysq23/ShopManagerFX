package pl.shop.util;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckComboBox;

public final class ValidatorUtil {

    private static ValidatorUtil instance;

    public static ValidatorUtil getInstance() {
        if (instance == null) {
            instance = new ValidatorUtil();
        }
        return instance;
    }

    public boolean validField(TextField field) {
        boolean valid = true;
        if (field.getText() == null || field.getText().trim().isEmpty()) {
            valid = false;
            setErrorStyle(field, true);
        } else {
            setErrorStyle(field, false);
        }
        return valid;
    }

    public boolean validCombo(ComboBox combo) {
        boolean valid = true;
        if (combo.getValue() == null) {
            valid = false;
            setErrorStyle(combo, true);
        } else {
            setErrorStyle(combo, false);
        }
        return valid;
    }

    public boolean validCheckComboBox(CheckComboBox checkComboBox) {
        boolean valid = true;
        if (checkComboBox.getCheckModel().getCheckedItems().isEmpty()) {
            valid = false;
            setErrorStyle(checkComboBox, true);
        } else {
            setErrorStyle(checkComboBox, false);
        }
        return valid;
    }

    private void setErrorStyle(Control control, boolean error) {
        ObservableList<String> styleClass = control.getStyleClass();
        if (error) {
            if (!styleClass.contains("error")) {
                styleClass.add("error");
            }
        } else {
            styleClass.removeAll("error");
        }
    }
}
