package dev.graphql.movieapi.services;

import dev.graphql.movieapi.exception.MovieNotFoundException;
import dev.graphql.movieapi.models.Movie;
import dev.graphql.movieapi.models.MovieInput;
import dev.graphql.movieapi.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public List<Movie> getAllMovies(){
        //getAllMovies is the name of the function that will be called by the controller to Get All Movies
        return movieRepository.findAll(); //this queries with the database
    }

    public Movie addMovie(MovieInput movieInput){
        Movie movie = new Movie(movieInput.title(), movieInput.director(), movieInput.studio(), movieInput.releaseYear(), movieInput.movieCast());
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, MovieInput movieInput){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with given ID does not exist"));

        movie.setTitle(movieInput.title());
        movie.setDirector(movieInput.director());
        movie.setStudio(movieInput.studio());
        movie.setReleaseYear(movieInput.releaseYear());
        movie.setMovieCast(movieInput.movieCast());
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Integer id){
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with given ID does not exist"));
       this.movieRepository.deleteById(movie.getId());
       return true;
    }
}
