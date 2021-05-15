package org.fis2021.exceptions;

public class ProductAlreadyExists extends Exception {

    public ProductAlreadyExists(String username) {
        super(String.format("Produsul ce se doreste a fi adaugat exista deja in meniu!"));
    }
}
