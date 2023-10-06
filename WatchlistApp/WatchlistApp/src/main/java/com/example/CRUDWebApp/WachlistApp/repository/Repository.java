package com.example.CRUDWebApp.WachlistApp.repository;

import com.example.CRUDWebApp.WachlistApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Movie, Integer> {
}
