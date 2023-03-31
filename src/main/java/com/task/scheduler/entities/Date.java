package com.task.scheduler.entities;

public class Date {
    private String iso;
    private Datetime datetime;
    

    public Date(String iso, Datetime datetime) {
        this.iso = iso;
        this.datetime = datetime;
    }

    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Datetime getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Datetime datetime) {
        this.datetime = datetime;
    }
}