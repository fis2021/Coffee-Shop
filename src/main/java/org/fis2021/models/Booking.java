package org.fis2021.models;

import java.util.Date;

public class Booking {
    private String username;
    private String nume;
    private int NrPers;
    private String ora;
    private Date data;

    public Booking(String username ,String nume, int NrPers, String ora, Date data) {
        this.username=username;
        this.nume = nume;
        this.NrPers = NrPers;
        this.ora = ora;
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
