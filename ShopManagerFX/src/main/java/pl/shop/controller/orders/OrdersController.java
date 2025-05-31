package pl.shop.controller.orders;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pl.shop.mock.MockOrdersDatabase;
import pl.shop.mock.MockProductDatabase;
import pl.shop.mock.MockUsersDatabase;
import pl.shop.model.Order;
import pl.shop.model.Product;

import java.util.List;

public class OrdersController {


    @FXML
    private TableView<Order> ordersTable;
    @FXML private TableColumn<Order, Integer> calId;
    @FXML private TableColumn<Order, String> colCustomer;
    @FXML private TableColumn<Order, String> colData;
    @FXML private TableColumn<Order, String> colStatus;

    @FXML private VBox detailsOrderPane;
    @FXML private Label labelOrderId;
    @FXML private Label labelCustomer;
    @FXML private Label labelDate;
    @FXML private Label labelStatus;
    @FXML private Label labelTotal;
    @FXML private TextField searchOrderField;
    @FXML private ListView<String> productList;

    @FXML
    public void initialize() {

        calId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colCustomer.setCellValueFactory(cellData ->  new SimpleStringProperty(MockUsersDatabase.findById(cellData.getValue().customerProperty().get()).getLogin()));
        colData.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().statusProperty().get().getDisplayName()));

        FilteredList<Order> filteredData = new FilteredList<>(MockOrdersDatabase.getAllOrders(), p -> true);

        searchOrderField.textProperty().addListener((observable, oldValue, newValue) -> {
            String lowerCaseFilter = newValue.toLowerCase();
            System.out.println("Wyszukiwanie zamówienia: " + lowerCaseFilter);
            filteredData.setPredicate(order -> {
                if (newValue.isEmpty()) {
                    return true;
                }
                return order.getStatus().getDisplayName().toLowerCase().contains(lowerCaseFilter);
            });
        });

        ordersTable.setItems(filteredData);
        ordersTable.setOnMouseClicked(this::onOrderSelected);

    }

    private void onOrderSelected(MouseEvent event) {
        Order selectedOrder = ordersTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            List<Product> products = MockProductDatabase.findByIds(selectedOrder.getProducts().reversed());
            labelOrderId.setText("ID: " + selectedOrder.getId());
            labelCustomer.setText("Klient: " + MockUsersDatabase.findById(selectedOrder.getCustomer()).getLogin());
            labelDate.setText("Data: " + selectedOrder.getDate());
            labelStatus.setText("Status: " + selectedOrder.getStatus().getDisplayName());
            labelTotal.setText("Łączna kwota: " + getTotal(products) + " zł");

            ObservableList<String> productNames = FXCollections.observableArrayList(products.stream().map(Product::getName).toList());
            productList.setItems(productNames);
        }
    }

    private double getTotal(List<Product> products) {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

}
