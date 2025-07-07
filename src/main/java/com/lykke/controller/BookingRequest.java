package com.lykke.controller;

public class BookingRequest {
    public String username;
    public Long travelOptionId;
    public Integer numberOfSeats;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTravelOptionId() {
        return travelOptionId;
    }

    public void setTravelOptionId(Long travelOptionId) {
        this.travelOptionId = travelOptionId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}

