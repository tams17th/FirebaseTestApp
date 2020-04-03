package com.example.myapplication;

public class TravelDeal
{
    private String name;
    private String description;
    private String place;

    public TravelDeal() {}
    public TravelDeal(String name, String description, String place) {
        this.setName(name);
        this.setDescription(description);
        this.setPlace(place);
    }


    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
