package com.example.CRUDWebApp.WachlistApp.service;

import com.example.CRUDWebApp.WachlistApp.model.Movie;
import com.example.CRUDWebApp.WachlistApp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    @Autowired
    Repository repository;
    @Autowired
    RatingService ratingService;

    public void store(Movie movie) {
        if(ratingService.setRating(movie) != null) {
            movie.setRating(Double.parseDouble(ratingService.setRating(movie)));
        }
        repository.save(movie);
    }

    public void update(Movie movie) {
        Movie toBeUpdated = repository.findById(movie.getId()).get();
        toBeUpdated.setTitle(movie.getTitle());
        toBeUpdated.setPriority(movie.getPriority());
        toBeUpdated.setRating(movie.getRating());
        toBeUpdated.setComment(movie.getComment());

        repository.save(toBeUpdated);
    }

    public void deleteMovie(Integer id) {
        repository.deleteById(id);
    }

    public Movie get(Integer id) {
        return repository.findById(id).get();
    }

    public List<Movie> getall() {
        return repository.findAll();
    }
}
