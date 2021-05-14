package org.fis2021.services;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis2021.models.Order;

import java.util.ArrayList;
public class ComandaService {
    private static ObjectRepository<Order> ordRepository;

    public static void initService() {
        ordRepository = DBService.getDatabase().getRepository(Order.class);
    }

    public static void addOrd(String username, String nume, String data, String ora) {
        ordRepository.insert(new Order(username, nume, ora, data));
    }

    public static ArrayList<Order> getAll(){
        ArrayList<Order> result = new ArrayList<>();
        for(Order b :  ordRepository.find()){
            result.add(b);
        }

        return result;
    }
}
