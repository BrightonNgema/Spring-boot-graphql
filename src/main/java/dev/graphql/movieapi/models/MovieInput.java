package dev.graphql.movieapi.models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;

import java.util.List;

public record MovieInput (
         String title,

         String director,

         String studio,

         Integer releaseYear,

         List<String> movieCast
){

}
