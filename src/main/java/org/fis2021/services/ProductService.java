package org.fis2021.services;

import org.dizitart.no2.objects.ObjectRepository;
import org.fis2021.exceptions.ProductAlreadyExists;
import org.fis2021.models.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ProductService {
    private static ObjectRepository<Product> proRepository;

    public static void initService() {
        proRepository = DBService.getDatabase().getRepository(Product.class);
    }

    public static void addProduct(String nume, float pret) throws ProductAlreadyExists {
        checkProductDoesNotAlreadyExist(nume);
        proRepository.insert(new Product(nume, pret));
    }

    private static void checkProductDoesNotAlreadyExist(String nume) throws ProductAlreadyExists {
        for (Product product : proRepository.find()) {
            if (product.getNume().equals(nume))
                throw new ProductAlreadyExists(nume);
        }
    }

    public static ArrayList<Product> getAll(){
        ArrayList<Product> result = new ArrayList<>();
        for(Product b :  proRepository.find()){
            result.add(b);
        }

        return result;
    }
}
