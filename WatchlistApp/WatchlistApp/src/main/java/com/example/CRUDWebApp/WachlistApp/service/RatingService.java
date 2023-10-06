package com.example.CRUDWebApp.WachlistApp.service;

import com.example.CRUDWebApp.WachlistApp.model.Movie;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
    String ApiUrl = "https://www.omdbapi.com/?i=tt3896198&apikey=ce291461&t=";
    public String setRating(Movie movie) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ObjectNode> response = restTemplate.getForEntity(ApiUrl + movie.getTitle(), ObjectNode.class);
            ObjectNode json = response.getBody();
            return json.path("imdbRating").asText();
        } catch(Exception e) {
            System.out.println("Rating not found on imdb");
            return null;
        }

    }
}
