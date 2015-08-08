package com.brazhenko.controller;

import com.brazhenko.entity.Cinemas;
import com.brazhenko.entity.Movie;
import com.brazhenko.entity.Schedule;
import com.brazhenko.entity.User;
import com.brazhenko.service.CinemasService;
import com.brazhenko.service.MovieService;
import com.brazhenko.service.SchdeuleService;
import com.brazhenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 05.08.2015.
 */
@Controller
@RequestMapping("/login")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CinemasService cinemasService;

    @Autowired
    MovieService movieService;

    @Autowired
    SchdeuleService scheduleService;

    Movie movie =new Movie();
    Cinemas cinemas = new Cinemas();
    Schedule schedule = new Schedule();
    User user = new User();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(movie.getName());
        user = userService.getUserByEmail(email);
        if (user.getAdmin()){
            model.addAttribute("cinemas", cinemasService.getCinema());
            model.addAttribute("movie", movieService.getMovie());
            model.addAttribute("schedule", scheduleService.getSchdeule());
            return "adminView";
        }
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete (HttpServletRequest request, Model model){

        if (request.getParameter("cinemaId")!=null){
            Long cinemaId = Long.parseLong(request.getParameter("cinemaId"));
            cinemas=cinemasService.getCinemaById(cinemaId);
            cinemasService.deleteCinema(cinemas);
        }
        if (request.getParameter("movieId")!=null){
            Long movieId = Long.parseLong(request.getParameter("movieId"));
            movie=movieService.getMovieById(movieId);
            movieService.deleteMovie(movie);
        }
        if (request.getParameter("scheduleId")!=null){
            Long scheduleId = Long.parseLong(request.getParameter("scheduleId"));
            schedule=scheduleService.getSchdeuleById(scheduleId);
            scheduleService.deleteSchdeule(schedule);
        }
        return "adminView";
    }

    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public String addUser (Model model){
        return "addUser";
    }

}
