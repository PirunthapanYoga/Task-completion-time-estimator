package com.task.scheduler.entities;
import java.util.List;

public class Holiday {
    private String name;
    private String description;
    private Country country;
    private Date date;
    private List<String> type;
    private String primaryType;
    private String canonicalUrl;
    private String urlid;
    private String locations;
    private String states;
    

    public Holiday(String name, String description, Country country, Date date, List<String> type, String primaryType, String canonicalUrl, String urlid, String locations, String states) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.date = date;
        this.type = type;
        this.primaryType = primaryType;
        this.canonicalUrl = canonicalUrl;
        this.urlid = urlid;
        this.locations = locations;
        this.states = states;
        System.out.println(date);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getType() {
        return this.type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getUrlid() {
        return this.urlid;
    }

    public void setUrlid(String urlid) {
        this.urlid = urlid;
    }

    public String getLocations() {
        return this.locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getStates() {
        return this.states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}