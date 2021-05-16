package org.fis2021.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class InregistrareTest {

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
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        stage.setScene(new Scene(root, 640, 800));
        stage.show();
    }

    @Test
    void testNavigation(FxRobot robot) {
        robot.clickOn("#swap");
        assertThat(stage.getTitle()).isEqualTo("Autentificare - CoffeeShop");
    }

    @Test
    void testRegister(FxRobot robot) {
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Campurile trebuie completate!");

        robot.clickOn("#username");
        robot.write("user");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Campurile trebuie completate!");

        robot.clickOn("#password");
        robot.write("user");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#message").queryText().getText()).isEqualTo("Contul a fost creat cu succes!");
    }
}