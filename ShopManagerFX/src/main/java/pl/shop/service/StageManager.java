package pl.shop.service;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class StageManager {

    private static StageManager instance;
    private Stage stage;
    private String userName = "default";
    private HashMap<String, URL> screenMap = new HashMap<>();

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
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
        this.stage.show();
    }

    public void loadModal(String modalName, String modalTitle, Integer width, Integer height) throws IOException {
        Stage searchStage = new Stage();
        searchStage.initModality(Modality.APPLICATION_MODAL);
        searchStage.setResizable(false);
        searchStage.setTitle(modalTitle);
        Parent root = new FXMLLoader(this.screenMap.get(modalName)).load();
        Scene scene = new Scene(root, width, height);
        searchStage.setScene(scene);
        searchStage.showAndWait();
    }

    public Parent getParent(String name) {
        try {
            return new FXMLLoader(this.screenMap.get(name)).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
