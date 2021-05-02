package com.maxkorte.Urlaubsverwaltung;

import java.time.LocalDate;
import java.util.Objects;

public class Urlaubsantrag {
    private final String vorname;
    private final String nachname;
    private final LocalDate urlaubVon;
    private final LocalDate urlaubBis;

    public Urlaubsantrag(String vorname, String nachname, LocalDate urlaubVon, LocalDate urlaubBis) {
        if(vorname == null || nachname == null || urlaubVon == null || urlaubBis == null)
            throw new IllegalArgumentException("Argumente dürfen nicht null sein!");

        this.vorname = vorname;
        this.nachname = nachname;
        this.urlaubVon = urlaubVon;
        this.urlaubBis = urlaubBis;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public LocalDate getUrlaubVon() {
        return urlaubVon;
    }

    public LocalDate getUrlaubBis() {
        return urlaubBis;
    }

    @Override
    public String toString() {
        return "Urlaubsantrag{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", urlaubVon='" + urlaubVon + '\'' +
                ", urlaubBis='" + urlaubBis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urlaubsantrag that = (Urlaubsantrag) o;
        return getVorname().equals(that.getVorname()) && getNachname().equals(that.getNachname()) && getUrlaubVon().equals(that.getUrlaubVon()) && getUrlaubBis().equals(that.getUrlaubBis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVorname(), getNachname(), getUrlaubVon(), getUrlaubBis());
    }
}
