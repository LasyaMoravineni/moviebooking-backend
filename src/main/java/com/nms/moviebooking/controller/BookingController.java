package com.nms.moviebooking.controller;

import com.nms.moviebooking.dto.BookingResponseDTO;
import com.nms.moviebooking.model.Booking;
import com.nms.moviebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingResponseDTO bookTickets(@RequestBody Booking booking) {
        return bookingService.bookTickets(booking);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }
}
