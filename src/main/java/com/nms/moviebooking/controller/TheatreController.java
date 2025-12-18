package com.nms.moviebooking.controller;

import com.nms.moviebooking.model.Theatre;
import com.nms.moviebooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@CrossOrigin(origins = "*")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return theatreService.addTheatre(theatre);
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }
}
