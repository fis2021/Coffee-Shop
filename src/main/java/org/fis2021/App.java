package org.fis2021;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.fis2021.models.User;
import org.fis2021.services.DBService;
import org.fis2021.services.FileSystemService;
import org.fis2021.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setMinHeight(480);
        stage.setMinWidth(640);
        FileSystemService.initDirectory();
        DBService.initDatabase();
        UserService.initService();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Autentificare - CoffeeShop");
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}