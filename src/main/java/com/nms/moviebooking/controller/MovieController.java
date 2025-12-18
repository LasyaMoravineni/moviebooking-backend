package com.nms.moviebooking.controller;

import com.nms.moviebooking.model.Movie;
import com.nms.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/language/{language}")
    public List<Movie> getByLanguage(@PathVariable String language) {
        return movieService.getMoviesByLanguage(language);
    }

    @GetMapping("/upcoming")
    public List<Movie> getUpcomingMovies() {
        return movieService.getUpcomingMovies();
    }
}
