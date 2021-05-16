package org.fis2021.services;

import org.dizitart.no2.Nitrite;
import org.fis2021.models.Booking;

import static org.fis2021.services.FileSystemService.getPathToFile;

public class DBService {

    private static Nitrite database;

    public static void initDatabase() {
        database = Nitrite.builder()
                .filePath(getPathToFile("coffeeShopDB.db").toFile())
                .openOrCreate("admin", "coffeeshop");
    }

    public static Nitrite getDatabase(){
        return database;
    }

    public static void closeDatabase(){ database.close();}
}
