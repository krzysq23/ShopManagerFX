package pl.shop.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty quantity;
    private final SimpleDoubleProperty price;

    public Product(int id, String name, int quantity, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleDoubleProperty(price);
    }

    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public int getQuantity() { return quantity.get(); }
    public double getPrice() { return price.get(); }

    public SimpleIntegerProperty idProperty() { return id; }
    public SimpleStringProperty nameProperty() { return name; }
    public SimpleIntegerProperty quantityProperty() { return quantity; }
    public SimpleDoubleProperty priceProperty() { return price; }
}