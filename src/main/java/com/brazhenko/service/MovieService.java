package com.brazhenko.service;

import com.brazhenko.dao.MovieDAOImpl;
import com.brazhenko.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Admin on 24.07.2015.
 */
@Service
//@RequestMapping("/movie")
public class MovieService {

        @Autowired
        private MovieDAOImpl movieDAO;

    public Long addMovie (Movie movie){
            Long id = movieDAO.addMovie(movie);
            return id;
        }

        public List<Movie> getMovie(){
            List movieId= movieDAO.getMovie();
            return movieId;
        }

        public Movie getMovieById(Long id){
            Movie movier = movieDAO.getMovieById(id);
            return movier;
        }

        public void updateMovie(Movie movies){
            movieDAO.updateMovie(movies);
        }

        public void deleteMovie(Movie movies){
            movieDAO.deleteMovie(movies);
        }
    }
