package CollectionLesson.HomeTask.List.LinkedMap;

import com.sun.security.jgss.GSSUtil;
import com.sun.source.tree.Tree;

import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CinemaRunner {

    public static void main(String[] args) {

        Map<Integer, TreeSet<Film>> findFilm = new LinkedHashMap<>();


        Cinema cinema = new Cinema(findFilm);
        cinema.addFilm(new Film(9, 2021, Month.JULY, Genre.ACTION, 7));
        cinema.addFilm(new Film(123, 2021, Month.APRIL, Genre.MUSICAL, 9));
        cinema.addFilm(new Film(1001, 2021, Month.MAY, Genre.MELODRAMA, 10));
        cinema.addFilm(new Film(145, 2021, Month.AUGUST, Genre.MELODRAMA, 5));
        cinema.addFilm(new Film(345, 2021, Month.AUGUST, Genre.ACTION, 3));
        System.out.println(cinema);

        cinema.getFilmYear(2024);
        cinema.getFilmYearAndMonth(2021, Month.MAY);
        cinema.getFilmGenre(Genre.ACTION);
        cinema.getListTop10();

    }
}

