package org.fis2021.models;

import java.time.LocalDate;
import java.util.Date;

public class Booking {
    private String username;
    private String nume;
    private int NrPers;
    private String ora;
    private String data;

    public Booking(String username ,String nume, int NrPers, String ora, String data) {
        this.username=username;
        this.nume = nume;
        this.NrPers = NrPers;
        this.ora = ora;
        this.data = data;
    }

    public Booking(){

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

    public int getNrPers() {
        return NrPers;
    }

    public void setNrPers(int nrPers) {
        NrPers = nrPers;
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

        Booking res= (Booking) o;

        if (!nume.equals(res.nume)) return false;
        if (NrPers!=res.NrPers) return false;
        if (!ora.equals(res.ora)) return false;
        return data.equals(res.data);
    }

}
