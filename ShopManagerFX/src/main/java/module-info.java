module pl.shop.shopmanagerfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens pl.shop to javafx.fxml;
    exports pl.shop;
    exports pl.shop.controller;
    opens pl.shop.controller to javafx.fxml;
}