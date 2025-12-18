package com.nms.moviebooking.controller;

import com.nms.moviebooking.dto.ShowResponseDTO;
import com.nms.moviebooking.model.Show;
import com.nms.moviebooking.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "*")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public ShowResponseDTO addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @GetMapping("/movie/{movieId}")
    public List<Show> getShowsByMovie(@PathVariable Long movieId) {
        return showService.getShowsByMovie(movieId);
    }

    @GetMapping("/theatre/{theatreId}")
    public List<Show> getShowsByTheatre(@PathVariable Long theatreId) {
        return showService.getShowsByTheatre(theatreId);
    }
}
