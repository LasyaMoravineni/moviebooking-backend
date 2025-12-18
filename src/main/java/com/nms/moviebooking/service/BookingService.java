package com.nms.moviebooking.service;

import com.nms.moviebooking.model.Booking;
import com.nms.moviebooking.dto.BookingResponseDTO;
import com.nms.moviebooking.exception.ResourceNotFoundException;
import com.nms.moviebooking.model.Show;
import com.nms.moviebooking.repository.BookingRepository;
import com.nms.moviebooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    public BookingResponseDTO bookTickets(Booking booking) {

        Show show = showRepository.findById(booking.getShow().getShowId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Show not found with id " + booking.getShow().getShowId()));

        if (show.getAvailableSeats() < booking.getSeatsBooked()) {
            throw new RuntimeException("Insufficient seats available");
        }

        show.setAvailableSeats(show.getAvailableSeats() - booking.getSeatsBooked());
        showRepository.save(show);

        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(show.getPrice() * booking.getSeatsBooked());

        Booking savedBooking = bookingRepository.save(booking);

        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setBookingId(savedBooking.getBookingId());
        dto.setMovieTitle(show.getMovie().getTitle());
        dto.setTheatreName(show.getTheatre().getName());
        dto.setShowTime(show.getShowTime());
        dto.setSeatsBooked(savedBooking.getSeatsBooked());
        dto.setTotalAmount(savedBooking.getTotalAmount());
        dto.setBookingTime(savedBooking.getBookingTime());

        return dto;
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserUserId(userId);
    }
}
