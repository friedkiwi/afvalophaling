package gent.gouvernementstraat.afvalophaling.models;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Timestamp;

public class Ophaaldag {
    private Date datum;
    private ArrayList<Ophaling> ophalingen;

    public Date getBuitenzetDatum() {
        return java.sql.Date.valueOf(((new Timestamp(datum.getTime())).toLocalDateTime().minusDays(1).toLocalDate()));
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public ArrayList<Ophaling> getOphalingen() {
        return ophalingen;
    }

    public void setOphalingen(ArrayList<Ophaling> ophalingen) {
        this.ophalingen = ophalingen;
    }

    public void addOphaling(Ophaling ophaling) {
        this.ophalingen.add(ophaling);
    }

    public boolean hasOphalingen() {
        if (this.ophalingen.isEmpty())
            return false;
        return true;
    }

    public Ophaaldag(Date datum, ArrayList<Ophaling> ophalingen) {
        this.datum = datum;
        this.ophalingen = ophalingen;
    }

    public Ophaaldag(Date datum) {
        this.datum = datum;
        this.ophalingen = new ArrayList<Ophaling>();
    }

    public Ophaaldag(LocalDateTime lokaleDatum){
        this.datum = java.sql.Date.valueOf(lokaleDatum.toLocalDate());
        this.ophalingen = new ArrayList<Ophaling>();
    }

    public Ophaaldag() {
        this.datum = java.sql.Date.valueOf(LocalDate.now());
        this.ophalingen = new ArrayList<Ophaling>();
    }
}
