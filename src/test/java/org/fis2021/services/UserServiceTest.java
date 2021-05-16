package org.fis2021.services;

import org.apache.commons.io.FileUtils;
import org.fis2021.exceptions.InvalidCredentials;
import org.fis2021.exceptions.UsernameAlreadyExists;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserServiceTest {
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
    void tearDown() throws Exception{
        DBService.closeDatabase();
    }

    @Test
    void testInitService() {
        UserService.initService();
        assertThat(UserService.getUserRepository()).isNotNull();
    }

    @Test
    void testAddGetUser() throws UsernameAlreadyExists, InvalidCredentials {
        UserService.addUser("user", "user", "Client");
        assertThat(UserService.getUser("user")).isNotNull();
        assertThat(UserService.getUser("user").getUsername()).isEqualTo("user");
        assertThat(UserService.getUser("user").getPassword()).isEqualTo(UserService.getHashedUserPassword("user"));
        assertThat(UserService.getUser("user").getRole()).isEqualTo("Client");
    }

    @Test
    void noSameUsername() {
        assertThrows(UsernameAlreadyExists.class, () -> {
            UserService.addUser("cafenea", "cafenea", "Cafenea");
            UserService.addUser("cafenea", "cafenea", "Cafenea");
        });
    }
}