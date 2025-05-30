package pl.shop.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pl.shop.mock.MockEventsDatabase;
import pl.shop.model.Event;
import pl.shop.service.AlertService;

import java.io.IOException;
import java.time.LocalDate;

public class DashboardController {

    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private ListView<String> lowStockList;
    @FXML
    private ListView<String> eventsListView;
    @FXML
    private TextField newEventField;
    @FXML
    private DatePicker eventDatePicker;

    public void initialize() {

        ObservableList<String> lowStock = MockEventsDatabase.getAllEventsAsStringList();
        lowStockList.setItems(lowStock);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Dane sprzedaży");
        series.getData().add(new XYChart.Data<>(1, 23));
        series.getData().add(new XYChart.Data<>(2, 14));
        series.getData().add(new XYChart.Data<>(3, 15));
        series.getData().add(new XYChart.Data<>(4, 24));
        series.getData().add(new XYChart.Data<>(5, 34));
        series.getData().add(new XYChart.Data<>(6, 36));
        series.getData().add(new XYChart.Data<>(7, 22));
        lineChart.getData().add(series);

        ObservableList<String> items = MockEventsDatabase.getAllEventsAsStringList();
        eventsListView.setItems(items);

        eventDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void handleAddNewEvent(ActionEvent e) throws IOException {
        String eventName = newEventField.getText();
        if(!eventName.isEmpty() && eventDatePicker.getValue() != null) {
            Event event = new Event(0, eventName, eventDatePicker.getValue().atStartOfDay());
            MockEventsDatabase.addEvent(event);
            eventsListView.getItems().add(event.toString());
            newEventField.setText("");
        } else {
            AlertService.show(Alert.AlertType.ERROR, "Błąd", "Wprowadź poprawną nazwę i datę");
        }

    }

}
