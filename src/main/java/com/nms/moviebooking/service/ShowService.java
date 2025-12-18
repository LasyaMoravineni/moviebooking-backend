package com.nms.moviebooking.service;

import com.nms.moviebooking.dto.ShowResponseDTO;
import com.nms.moviebooking.model.Show;
import com.nms.moviebooking.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public ShowResponseDTO addShow(Show show) {

        Show savedShow = showRepository.save(show);

        ShowResponseDTO dto = new ShowResponseDTO();
        dto.setShowId(savedShow.getShowId());
        dto.setMovieTitle(savedShow.getMovie().getTitle());
        dto.setTheatreName(savedShow.getTheatre().getName());
        dto.setShowTime(savedShow.getShowTime());
        dto.setPrice(savedShow.getPrice());
        dto.setAvailableSeats(savedShow.getAvailableSeats());

        return dto;
    }

    public List<Show> getShowsByMovie(Long movieId) {
        return showRepository.findByMovieMovieId(movieId);
    }

    public List<Show> getShowsByTheatre(Long theatreId) {
        return showRepository.findByTheatreTheatreId(theatreId);
    }
}
