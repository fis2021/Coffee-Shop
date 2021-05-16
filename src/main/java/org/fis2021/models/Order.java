package org.fis2021.models;

public class Order {
    private String username;
    private String nume;
    private String ora;
    private String data;

    public Order(String username ,String nume, String ora, String data) {
        this.username=username;
        this.nume = nume;
        this.ora = ora;
        this.data = data;
    }

    public Order(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order= (Order) o;

        if (!nume.equals(order.nume)) return false;
        if (!ora.equals(order.ora)) return false;
        return data.equals(order.data);
    }
}

