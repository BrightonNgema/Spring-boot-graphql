package dev.graphql.movieapi.controllers;

import dev.graphql.movieapi.models.Movie;
import dev.graphql.movieapi.models.MovieInput;
import dev.graphql.movieapi.services.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//Controller defines the end points / functions that will be exposed and used to query or mutate
//User hits methods in Controller ->  Calls services -> Queries Database
@Controller
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService){
        this.movieService = movieService;
    }

    @QueryMapping
    List<Movie> getAllMoviesHandler(){ //this is the method used my graphql to be called in the schema
        return movieService.getAllMovies();
    }
    @MutationMapping
    Movie addMovieHandler(@Argument MovieInput movieInput){
        return movieService.addMovie(movieInput);
    }
}
