package pl.shop;

import javafx.stage.Stage;
import pl.shop.service.StageManager;
import javafx.scene.image.Image;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("ShopManagerFX");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/app-icon.png")));
        stage.setMinWidth(800);
        stage.setMinHeight(500);

        StageManager.getInstance().setPrimaryStage(stage);
        StageManager.getInstance().addScreen("login", getClass().getResource("views/login-view.fxml"));
        StageManager.getInstance().addScreen("main", getClass().getResource("views/main-view.fxml"));
        StageManager.getInstance().addScreen("home", getClass().getResource("views/dashboard-view.fxml"));
        StageManager.getInstance().addScreen("products", getClass().getResource("views/products/products-view.fxml"));
        StageManager.getInstance().addScreen("categories", getClass().getResource("views/products/categories-view.fxml"));
        StageManager.getInstance().addScreen("orders", getClass().getResource("views/orders/orders-view.fxml"));
        StageManager.getInstance().addScreen("users", getClass().getResource("views/settings/users-view.fxml"));
        StageManager.getInstance().addScreen("settings", getClass().getResource("views/settings/settings-view.fxml"));
        StageManager.getInstance().addScreen("search_modal", getClass().getResource("views/modals/search-modal.fxml"));
        StageManager.getInstance().addScreen("product_modal", getClass().getResource("views/modals/product-modal.fxml"));
        StageManager.getInstance().addScreen("category_modal", getClass().getResource("views/modals/category-modal.fxml"));
        StageManager.getInstance().addScreen("user_modal", getClass().getResource("views/modals/user-modal.fxml"));

        StageManager.getInstance().loadScene("main");
    }

    public static void main(String[] args) {
        launch();
    }
}