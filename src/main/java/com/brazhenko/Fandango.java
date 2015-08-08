package com.brazhenko;


import com.brazhenko.dao.CinemasDAOImpl;
import com.brazhenko.dao.MovieDAOImpl;
import com.brazhenko.dao.ScheduleDAOImpl;
import com.brazhenko.dao.UserDAOImpl;
import com.brazhenko.dao.daoInterface.CinemasDao;
import com.brazhenko.dao.daoInterface.MovieDAO;
import com.brazhenko.dao.daoInterface.ScheduleDAO;
import com.brazhenko.dao.daoInterface.UserDAO;
import com.brazhenko.entity.Cinemas;
import com.brazhenko.entity.Movie;
import com.brazhenko.entity.Schedule;
import com.brazhenko.entity.User;
import com.brazhenko.fandangoUtils.FandangoUtils;
import com.brazhenko.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 08.07.2015.
 */
public class Fandango {

    @Autowired
    private static CinemasDao cDAO = new CinemasDAOImpl();

    @Autowired
    private static MovieDAO mDAO = new MovieDAOImpl();

    private static Cinemas cinema=new Cinemas();
    private static Movie movie = new Movie();

    @Autowired
    private static ScheduleDAO sDAO = new ScheduleDAOImpl();

    public static void main (String[] args){

//         Create movie list in db
        List<Movie> moviesetList = generateMovie();
        for (Movie movie: moviesetList ){
            movie.setMovieId(mDAO.addMovie(movie));
        }

//         Create cinema list in db
        List<Cinemas> cinemaList = generateCinema();
        for (Cinemas cinema: cinemaList){
            cinema.setCinemaId(cDAO.addCinema(cinema));
        }

//         Create schedule list in db
        List<Schedule> scheduleList = generateSchedule();
        for (Schedule schedule:scheduleList){
            schedule.setScheduleId(sDAO.addSchedule(schedule));
        }

        UserDAO userService = new UserDAOImpl();
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setPassword("nimda");
        user.setAdmin(true);
        userService.addUser(user);

        User user2 = new User();
        user2.setEmail("brazhenko@list.ru");
        user2.setPassword("nimda");
        user2.setAdmin(false);
        userService.addUser(user2);


        FandangoUtils.getSessionFacory().close();
    }

    private static List<Cinemas> generateCinema(){
        List<Cinemas> cinemaList = new ArrayList<Cinemas>();
        Cinemas cinema1 = new Cinemas();
        cinema1.setAdresses("g. Dnepropetrovsk, ul. Glinki, 2. Telefon: Infocentr (056) 339-000; (092) 304-94-55");
        cinema1.setName("Most Kino");
        cinema1.setNumberOfSeats(200);
        cinemaList.add(cinema1);

        Cinemas cinema2 = new Cinemas();
        cinema2.setAdresses("g. Dnepropetrovsk, prosp. im. gaz. Pravdy, 86. Telefon: (056) 371-42-02 - spravka, 373-60-00 - avtootv.");
        cinema2.setName("Pravda Kino");
        cinema2.setNumberOfSeats(150);
        cinemaList.add(cinema2);

        Cinemas cinema3 = new Cinemas();
        cinema3.setAdresses("g. Dnepropetrovsk, Bul'var Zvjozdnyj, 1a. Telefon: (056) 373-91-01 - bronirovanie");
        cinema3.setName("Kinostancija");
        cinema3.setNumberOfSeats(180);
        cinemaList.add(cinema3);

        Cinemas cinema4 = new Cinemas();
        cinema4.setAdresses("g. Dnepropetrovsk, ul. Marii Kjuri 5. Telefon: (056) 339-000; (092) 306-07-92");
        cinema4.setName("Materik Kino");
        cinema4.setNumberOfSeats(220);
        cinemaList.add(cinema4);

        Cinemas cinema5 = new Cinemas();
        cinema5.setAdresses("pgt. Jubilejnyj, ul. Nizhnedneprovskaja, 17. Telefon: 067-322-90-73");
        cinema5.setName("Mul'tipleks v TRC Karavan");
        cinema5.setNumberOfSeats(250);
        cinemaList.add(cinema5);

        return cinemaList;
    }

    public static List<Movie> generateMovie(){
        List<Movie> movieList = new ArrayList();

         Movie movie1 = new Movie();
        movie1.setName("Terminator: Genezis");
        movie1.setDescription("Kogda Dzhon Konnor, lider soprotivlenija, posylaet serzhanta Kajla Riza nazad v 1984 god, chtoby zashhitit' Saru Konnor i spasti budushhee, neozhidannyj povorot sobytij sozdaet razlom vo vremeni.");
        movie1.setRating(7.1);
        movie1.setGenre("fantastika, boevik, triller");
        movie1.setDuration(68);
        movieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Tretij lishnij 2");
        movie2.setDescription("Pljushevyj bespredel'shhik prodolzhaet svodit' s uma chopornuju intelligenciju. Na jetot raz govorjashhij medvezhonok s bol'shim jego i ego dlinnonogaja blondinka reshili zavesti rebjonka.");
        movie2.setRating(7.0);
        movie2.setGenre("komedija");
        movie2.setDuration(62);
        movieList.add(movie2);

        Movie movie3 = new Movie();
        movie3.setName("Vdali ot obezumevshej tolpy");
        movie3.setDescription("Krasivaja molodaja zhenshhina podderzhivaet otnoshenija s tremja ochen' raznymi muzhchinami.");
        movie3.setRating(7.3);
        movie3.setGenre("drama");
        movie3.setDuration(87);
        movieList.add(movie3);

        Movie movie4 = new Movie();
        movie4.setName("Super Majk XXL");
        movie4.setDescription("Proshlo tri goda posle togo, kak Majk na pike svoej populjarnosti zakonchil kar'eru striptizera, a klub �Koroli Tampy� uzhe pochti gotov priznat' svoe porazhenie.");
        movie4.setRating(6.2);
        movie4.setGenre("komedija, muzyka, drama");
        movie4.setDuration(134);
        movieList.add(movie4);

        Movie movie5 = new Movie();
        movie5.setName("Lico angela");
        movie5.setDescription("Posle progremevshego na ves' mir ubijstva molodoj devushki, v ital'janskij gorod Siena priezzhaet molodoj rezhisser dlja podgotovki k s#emkam fil'ma po motivam prestuplenija.");
        movie5.setRating(5.1);
        movie5.setGenre("triller");
        movie5.setDuration(121);
        movieList.add(movie5);

        Movie movie6 = new Movie();
        movie6.setName("Poltergejst");
        movie6.setDescription("Kogda strashnye prizraki zabirajut mladshuju doch', sem'e prihoditsja ob#edinit'sja, chtoby spasti ee�");
        movie6.setRating(5.1);
        movie6.setGenre("uzhasy, triller");
        movie6.setDuration(52);
        movieList.add(movie6);

        Movie movie7 = new Movie();
        movie7.setName("Ono");
        movie7.setDescription("Posle seksual'noj svjazi 19-letnjuju devushku po imeni Dzhej nachinajut muchat' strannye videnija i nepreodolimoe chuvstvo togo, chto kto-to ili chto-to za nej sledit�");
        movie7.setRating(7.0);
        movie7.setGenre("uzhasy, detektiv");
        movie7.setDuration(84);
        movieList.add(movie7);

        Movie movie8 = new Movie();
        movie8.setName("Mir Jurskogo perioda");
        movie8.setDescription("Tysjachi ljudej speshat uvidet' Mir Jurskogo perioda, no bezopasnoe na pervyj vzgljad razvlechenie mozhet obernut'sja ugrozoj dlja ih zhiznej�");
        movie8.setRating(7.4);
        movie8.setGenre("fantastika, prikljuchenija, boevik");
        movie8.setDuration(96);
        movieList.add(movie8);

        return movieList;
    }

        public static List<Schedule> generateSchedule(){
        List<Schedule> scheduleList= new ArrayList();

            Schedule schedule1 = new Schedule();
            movie=mDAO.getMovieById(2L);
            schedule1.setMovie(movie);
            cinema=cDAO.getCinemaById(1L);
            schedule1.setCinema(cinema);
            schedule1.setFreePlace(300);
            schedule1.setTime(new GregorianCalendar(2015, 8, 24, 19, 00));
            scheduleList.add(schedule1);

            Schedule schedule2 = new Schedule();
            movie=mDAO.getMovieById(1L);
            schedule2.setMovie(movie);
            cinema=cDAO.getCinemaById(2L);
            schedule2.setCinema(cinema);
            schedule2.setFreePlace(150);
            schedule2.setTime(new GregorianCalendar(2015,8,24,20,15));
            scheduleList.add(schedule2);

            Schedule schedule3 = new Schedule();
            movie=mDAO.getMovieById(3L);
            schedule3.setMovie(movie);
            cinema=cDAO.getCinemaById(3L);
            schedule3.setCinema(cinema);
            schedule3.setFreePlace(200);
            schedule3.setTime(new GregorianCalendar(2015, 8, 25, 19, 45));
            scheduleList.add(schedule3);

            Schedule schedule4 = new Schedule();
            movie=mDAO.getMovieById(4L);
            schedule4.setMovie(movie);
            cinema=cDAO.getCinemaById(4L);
            schedule4.setCinema(cinema);
            schedule4.setFreePlace(280);
            schedule4.setTime(new GregorianCalendar(2015,8,26,19,30));
            scheduleList.add(schedule4);

            Schedule schedule5 = new Schedule();
            movie=mDAO.getMovieById(3L);
            schedule5.setMovie(movie);
            cinema=cDAO.getCinemaById(3L);
            schedule5.setCinema(cinema);
            schedule5.setFreePlace(300);
            schedule5.setTime(new GregorianCalendar(2015,9,24,19,00));
            scheduleList.add(schedule5);

            return scheduleList;
    }

}
