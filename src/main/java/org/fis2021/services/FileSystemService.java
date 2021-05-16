package org.fis2021.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {

    private static final String APPLICATION_FOLDER = ".CoffeeShop";
    private static final String USER_FOLDER = System.getProperty("user.home");

    public static Path getPathToFile(String... path) {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER).resolve(Paths.get(".", path));
    }

    public static Path getHomeFolder(){
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static void initDirectory(){
        Path applicationHomePath = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
}