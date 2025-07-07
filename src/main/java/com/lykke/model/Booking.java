package com.lykke.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "travel_option_id", nullable = false)
    private TravelOption travelOption;

    private Integer numberOfSeats;
    private Double totalPrice;
    private LocalDateTime bookingDate;
    private String status;
    // getters, setters


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TravelOption getTravelOption() {
        return travelOption;
    }

    public void setTravelOption(TravelOption travelOption) {
        this.travelOption = travelOption;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


/*================== MYSQL SCHEMA ==================

CREATE TABLE users (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(255) UNIQUE,
password VARCHAR(255),
email VARCHAR(255),
full_name VARCHAR(255)
);

CREATE TABLE travel_option (
        travel_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        type VARCHAR(20),
source VARCHAR(100),
destination VARCHAR(100),
travel_date_time DATETIME,
price DECIMAL(10, 2),
available_seats INT
);

CREATE TABLE booking (
        booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        user_id BIGINT,
        travel_option_id BIGINT,
        number_of_seats INT,
        total_price DECIMAL(10,2),
booking_date DATETIME,
status VARCHAR(20),
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (travel_option_id) REFERENCES travel_option(travel_id)
        );*/
