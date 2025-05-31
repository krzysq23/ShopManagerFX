package pl.shop.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import pl.shop.util.ParamReceiver;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class StageManager {

    private static StageManager instance;
    private Stage stage;
    private String userName = "default";
    private String theme = "Light";
    private String cssPath = "/styles/light-style.css";
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

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
        Scene currentScene = StageManager.getInstance().getCurrentScene();
        if (theme.equals("Light")) {
            this.cssPath = "/styles/light-style.css";
            currentScene.getStylesheets().remove(getClass().getResource("/styles/dark-style.css").toExternalForm());
            currentScene.getStylesheets().add(getClass().getResource("/styles/light-style.css").toExternalForm());
        } else {
            this.cssPath = "/styles/dark-style.css";
            currentScene.getStylesheets().remove(getClass().getResource("/styles/light-style.css").toExternalForm());
            currentScene.getStylesheets().add(getClass().getResource("/styles/dark-style.css").toExternalForm());
        }
    }

    public String getCssPath() {
        return this.cssPath;
    }

    public void setCssPath(String path) {
        this.cssPath = path;
    }

    public Scene getCurrentScene() {
        return this.stage.getScene();
    }

    public void loadScene(String name) throws IOException {
        Parent root = new FXMLLoader(this.screenMap.get(name)).load();
        Scene currentScene = getCurrentScene();
        double width = 1000, height = 600;
        if(currentScene != null) {
            width = currentScene.getWidth();
            height = currentScene.getHeight();
        }
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource(this.cssPath).toExternalForm());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        this.stage.centerOnScreen();
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void loadModal(String modalName, String modalTitle, Integer width, Integer height, Object... obj) throws IOException {
        Stage modalScene = new Stage();
        modalScene.initModality(Modality.APPLICATION_MODAL);
        modalScene.setResizable(false);
        modalScene.setTitle(modalTitle);
        FXMLLoader loader = new FXMLLoader(this.screenMap.get(modalName));
        Parent root = loader.load();
        if(obj != null && obj.length > 0) {
            Object controller = loader.getController();
            if (controller instanceof ParamReceiver) {
                ((ParamReceiver) controller).receiveParams(obj);
            }
        }
        root.getStylesheets().add(getClass().getResource(this.cssPath).toExternalForm());
        Scene scene = new Scene(root, width, height);
        modalScene.setScene(scene);
        modalScene.showAndWait();
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
