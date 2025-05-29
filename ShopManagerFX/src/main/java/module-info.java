module pl.shop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens pl.shop to javafx.fxml;
    exports pl.shop;
    exports pl.shop.controller;
    opens pl.shop.controller to javafx.fxml;
    exports pl.shop.controller.products;
    opens pl.shop.controller.products to javafx.fxml;
    exports pl.shop.controller.orders;
    opens pl.shop.controller.orders to javafx.fxml;
    exports pl.shop.controller.settings;
    opens pl.shop.controller.settings to javafx.fxml;
    exports pl.shop.controller.modals;
    opens pl.shop.controller.modals to javafx.fxml;
}