package org.openjfx.ongmanagermvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("VInicio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ONGManager");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}