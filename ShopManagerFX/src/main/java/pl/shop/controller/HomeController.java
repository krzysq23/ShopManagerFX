package pl.shop.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class HomeController {

    @FXML
    private LineChart<Number, Number> lineChart;

    public void initialize() {

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
    }

}
