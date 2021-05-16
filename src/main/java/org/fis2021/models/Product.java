package org.fis2021.models;

public class Product {
    private String nume;
    private float pret;

    public Product(String nume, float pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public Product(){

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product order= (Product) o;

        if (this.pret != pret) return false;
        return nume.equals(order.nume);
    }
}