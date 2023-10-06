package com.example.CRUDWebApp.WachlistApp.controller;

import com.example.CRUDWebApp.WachlistApp.model.Movie;
import com.example.CRUDWebApp.WachlistApp.service.Services;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WatchlistControllers {
    @Autowired
    Services services;
    @GetMapping()
    public ModelAndView home() {
        String view = "index";
        return new ModelAndView(view);
    }
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistForm(@RequestParam(required = false) Integer id) {
        String view = "watchlistItemForm";
        Map<String, Object> model = new HashMap<>();
        Movie movie;
        if(id == null){
             movie = new Movie();
        } else {
            movie = services.get(id);
        }
        model.put("watchlistItem", movie);
        return new ModelAndView(view, model);
    }
    @PostMapping("/watchlistItemForm")
    public ModelAndView storeWatchlistItem(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return new ModelAndView("watchlistItemForm");
        }

        if(movie.getId() == null){
            services.store(movie);
        } else{
            services.update(movie);
        }


        RedirectView rd =new RedirectView();
        rd.setUrl("/watchlist");
        return new ModelAndView(rd);
    }
    @GetMapping("/watchlist")
    public ModelAndView watchlistItem(@RequestParam(required = false) Integer id) {
        String view = "watchlist";
        if(id != null) {
            services.deleteMovie(id);
        }
        Map<String, Object> model = new HashMap<>();
        List<Movie> list = services.getall();
        model.put("watchlistrows", list);
        model.put("noofmovies", list.size());
        return new ModelAndView(view, model);
    }

    // @DeleteMapping("/delete")
    // public ModelAndView deleteMovie(@RequestParam Integer id) {
    //     services.deleteMovie(id);
    //     RedirectView rd =new RedirectView();
    //     rd.setUrl("/watchlist");
    //     return new ModelAndView(rd);
    // }
}
