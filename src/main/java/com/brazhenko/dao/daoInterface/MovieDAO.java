package com.brazhenko.dao.daoInterface;

import com.brazhenko.entity.Movie;

import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
public interface MovieDAO {
    //Method to write new Movie in the DB
    Long addMovie(Movie movie);

    //Method to read all Movie
    List<Movie> getMovie();

    //Method to update Movie
    void updateMovie(Movie movie);

    Movie getMovieById(Long id);

    //Method to delete Movie
    void deleteMovie (Movie movie);
}
