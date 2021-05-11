package org.fis2021.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectFilter;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.fis2021.models.Booking;
import org.fis2021.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.fis2021.services.FileSystemService.getPathToFile;

public class RezervareService {
    private static ObjectRepository<Booking> resRepository;

    public static void initService() {
        resRepository = DBService.getDatabase().getRepository(Booking.class);
    }

    public static void addRes(String username, String nume, int NrPers, String data, String ora) {
        resRepository.insert(new Booking(username, nume, NrPers, ora, data));
    }

    public static ArrayList<Booking> getAll(){
        ArrayList<Booking> result = new ArrayList<>();
        for(Booking b :  resRepository.find()){
            result.add(b);
        }

        return result;
    }
}
