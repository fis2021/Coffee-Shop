package org.fis2021.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis2021.models.Booking;
import org.fis2021.models.User;

import java.util.Date;

import static org.fis2021.services.FileSystemService.getPathToFile;

public class RezervareService {
    private static ObjectRepository<Booking> resRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("coffeeShopDB.db").toFile())
                .openOrCreate("admin", "coffeeshop");

        resRepository = database.getRepository(Booking.class);
    }

    public static void addRes(String username, String nume, int NrPers, Date data, String ora) {
        resRepository.insert(new Booking(username, nume, NrPers, ora, data));
    }
}
