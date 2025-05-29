package pl.shop.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StageManager {

    private static StageManager instance;
    private Stage stage;
    private HashMap<String, URL> screenMap = new HashMap<>();
    private Map<String, String> sceneTitles = Map.of(
            "login", "Panel loggowania",
            "main", "Panel główny"
    );

    private StageManager() {
    }

    public static StageManager getInstance() {
        if (instance == null) {
            instance = new StageManager();
        }
        return instance;
    }

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    public void addScreen(String name, URL pane) {
        this.screenMap.put(name, pane);
    }

    public void removeScreen(String name) {
        this.screenMap.remove(name);
    }

    public void loadScene(String name) throws IOException {
        Parent root = new FXMLLoader(this.screenMap.get(name)).load();
        Scene currentScene = this.stage.getScene();
        double width = 1000, height = 600;
        if(currentScene != null) {
            width = currentScene.getWidth();
            height = currentScene.getHeight();
        }
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        this.stage.centerOnScreen();
        this.stage.setScene(scene);
        this.stage.setTitle(this.sceneTitles.get(name));
        this.stage.show();
    }
}
