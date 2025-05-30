package pl.shop.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Category {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;

    public Category(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public int getId() { return id.get(); }
    public String getName() { return name.get(); }

    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleStringProperty nameProperty() { return name; }

    @Override
    public String toString() {
        return name.getValue();
    }
}
