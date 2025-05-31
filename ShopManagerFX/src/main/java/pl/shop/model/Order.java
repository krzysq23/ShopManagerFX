package pl.shop.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Order {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty customer = new SimpleIntegerProperty();
    private final StringProperty date = new SimpleStringProperty();
    private final ObjectProperty<OrderStatus> status = new SimpleObjectProperty<>();
    private final ListProperty<Integer> products = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Order(int id, Integer customer, String date, OrderStatus status, List<Integer> products) {
        this.id.set(id);
        this.customer.set(customer);
        this.date.set(date);
        this.status.set(status);
        this.products.addAll(products);
    }

    public IntegerProperty idProperty() { return id; }
    public IntegerProperty customerProperty() { return customer; }
    public StringProperty dateProperty() { return date; }
    public ObjectProperty<OrderStatus> statusProperty() { return status; }
    public ListProperty<Integer> productsProperty() { return products; }

    public int getId() { return id.get(); }
    public Integer getCustomer() { return customer.get(); }
    public String getDate() { return date.get(); }
    public OrderStatus getStatus() { return status.get(); }
    public ObservableList<Integer> getProducts() { return products.get(); }

}
