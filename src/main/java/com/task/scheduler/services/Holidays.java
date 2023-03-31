package com.task.scheduler.services;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.task.scheduler.entities.Holiday;

public class Holidays {

    private String country;
    private int year;
    private String url;
    private ArrayList<Holiday> holidays;

    public Holidays(String country , int year , String api) {
        this.country = country;
        this.year = year;
        this.url = String.format("https://calendarific.com/api/v2/holidays?&api_key=%s&country=%s&year=%d",api,country,year);
        this.holidays=holidayJsonObjectParser();
    }

    public void setYear(int year){
       this.year=year;

    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public int getYear() {
        return this.year;
    }
    
    public ArrayList<Holiday> getHolidays() {
        return this.holidays;
    }

    // related to Holiday API
    private String getholidaysAPI(){
        try {

            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(this.url))
            .build();
            
           var response = HttpClient.newHttpClient()
                            .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .get()
                            .body();
            
            return response;

        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();

        }

        return null;
    }

    private JsonObject getholidayJson(){
        String body= getholidaysAPI();
        Gson gson = new Gson();
        JsonObject holidayObject =gson.fromJson(body, JsonObject.class);
        return holidayObject;
    }

    public JsonArray getDate(){
        JsonObject object =  getholidayJson();
        Gson gson = new Gson();
        JsonObject holidayJsonObject = gson.fromJson(object.get("response"), JsonObject.class);
        JsonArray holidayArrayJson = gson.fromJson(holidayJsonObject.getAsJsonArray("holidays"), JsonArray.class);
        return holidayArrayJson;
    }

    public ArrayList<Holiday> holidayJsonObjectParser(){
        Gson gson = new Gson();
        JsonArray holidayArrayJson = getDate();
        
        ArrayList<Holiday> holidays= new ArrayList<>();

        holidayArrayJson.forEach(e->{
            Holiday holiday = gson.fromJson(e, Holiday.class);
            holidays.add(holiday);
        });

        return holidays;
    }

    public boolean isHoliday(LocalDate leave){
        boolean result = false;

        for(int i = 0 ; i<holidays.size() ; i++){
            if(holidays.get(i).getDate().getDatetime().getMonth() == leave.getMonth().getValue() &&
                holidays.get(i).getDate().getDatetime().getYear() == leave.getYear() && 
                holidays.get(i).getDate().getDatetime().getDay() == leave.getDayOfMonth()){
                result = true;
            }
        }

        return result;
    }
}
