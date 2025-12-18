package com.nms.moviebooking.repository;

import com.nms.moviebooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);

    List<Movie> findByLanguage(String language);

    List<Movie> findByIsUpcoming(boolean isUpcoming);
}
