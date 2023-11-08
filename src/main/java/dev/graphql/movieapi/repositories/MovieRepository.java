package dev.graphql.movieapi.repositories;

import dev.graphql.movieapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
