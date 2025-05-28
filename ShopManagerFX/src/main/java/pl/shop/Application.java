package pl.shop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.shop.service.StageManager;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {

        StageManager.getInstance().setPrimaryStage(stage);
        StageManager.getInstance().addScreen("login", FXMLLoader.load(getClass().getResource("login-view.fxml")));
        StageManager.getInstance().addScreen("main", FXMLLoader.load(getClass().getResource("main-view.fxml")));

        StageManager.getInstance().loadScene("main");
    }

    public static void main(String[] args) {
        launch();
    }
}