package com.nms.moviebooking.service;

import com.nms.moviebooking.model.Movie;
import com.nms.moviebooking.exception.ResourceNotFoundException;
import com.nms.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }

    public List<Movie> getUpcomingMovies() {
        return movieRepository.findByIsUpcoming(true);
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
    }

}
