package com.lykke.service;

import com.lykke.controller.BookingRequest;
import com.lykke.model.Booking;
import com.lykke.model.TravelOption;
import com.lykke.model.User;
import com.lykke.repository.BookingRepository;
import com.lykke.repository.TravelOptionRepository;
import com.lykke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravelOptionRepository travelOptionRepository;

    public Booking createBooking(BookingRequest request) {
        User user = userRepository.findByUsername(request.username).orElseThrow();
        TravelOption travel = travelOptionRepository.findById(request.travelOptionId).orElseThrow();

        if (travel.getAvailableSeats() < request.numberOfSeats) {
            throw new IllegalArgumentException("Not enough seats available");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTravelOption(travel);
        booking.setNumberOfSeats(request.numberOfSeats);
        booking.setTotalPrice(travel.getPrice() * request.numberOfSeats);
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("CONFIRMED");

        travel.setAvailableSeats(travel.getAvailableSeats() - request.numberOfSeats);
        travelOptionRepository.save(travel);

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return bookingRepository.findByUser(user);
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setStatus("CANCELLED");

        TravelOption travel = booking.getTravelOption();
        travel.setAvailableSeats(travel.getAvailableSeats() + booking.getNumberOfSeats());
        travelOptionRepository.save(travel);

        bookingRepository.save(booking);
    }
}