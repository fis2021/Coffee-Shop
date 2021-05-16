package org.fis2021.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis2021.exceptions.UsernameAlreadyExists;
import org.fis2021.services.DBService;
import org.fis2021.services.FileSystemService;
import org.fis2021.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class AutentificareTest {
    private Stage stage;

    @BeforeAll
    static void beforeAll() {
        FileSystemService.initDirectory();
    }

    @BeforeEach
    void setUp() throws Exception{
        FileUtils.cleanDirectory(FileSystemService.getHomeFolder().toFile());
        DBService.initDatabase();
        UserService.initService();
    }

    @AfterEach
    void tearDown(){
        DBService.closeDatabase();
    }

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setHeight(800);
        stage.setWidth(640);
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Forum App - Login");
        stage.setScene(new Scene(root, 640, 800));
        stage.show();
    }

    @Test
    void testNavigation(FxRobot robot) {
        robot.clickOn("#swapButton");
        assertThat(stage.getTitle()).isEqualTo("Inregistrare - Coffee Shop");
    }

    @Test
    void testAutentificare(FxRobot robot) throws UsernameAlreadyExists {
        UserService.addUser("user", "user", "Client");
        UserService.addUser("user1", "user1", "Client");
        robot.clickOn("#loginButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Adauga username!");

        robot.clickOn("#username");
        robot.write("user2");

        robot.clickOn("#loginButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Adauga parola!");

        robot.clickOn("#password");
        robot.write("user");
        robot.clickOn("#loginButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Numele de utilizator user2 este invalid!");

        robot.clickOn("#username");
        robot.eraseText(1);
        robot.write("1");
        robot.clickOn("#loginButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Autentificare incorecta!");

        robot.clickOn("#username");
        robot.eraseText(1);
        robot.clickOn("#loginButton");
        assertThat(stage.getTitle()).isEqualTo("Coffee Shop");
    }
}