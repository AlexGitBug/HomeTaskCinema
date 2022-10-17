package CollectionLesson.HomeTask.List.LinkedMap;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */

import CollectionLesson.HomeTask.List.Chat_Task.User;
import com.sun.source.tree.Tree;

import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Cinema {


    private Map<Integer, TreeSet<Film>> filmByYear = new LinkedHashMap<>();
//    private static final int SIZE = 3;

    public Cinema() {
    }

    public Cinema(Map<Integer, TreeSet<Film>> filmByYear) {
        this.filmByYear = filmByYear;
    }

    public void addFilm(Film film) {
        filmByYear.putIfAbsent(film.getYear(), new TreeSet<>());
        filmByYear.get(film.getYear()).add(film);
    }


    public void getFilmYear(int year) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            if (entry.getKey() == year) {
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }
        }
    }

    public void getFilmYearAndMonth(int year, Month month) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            if (entry.getKey() == year) {
                Iterator<Film> iterator = entry.getValue().iterator();
                while (iterator.hasNext()) {
                    Film next = iterator.next();
                    if (next.getMonth() == month) {
                        System.out.println(next);
                    }
                }
            }
        }
    }

    public void getFilmGenre(Genre genre) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            Iterator<Film> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                Film next = iterator.next();
                if (next.getGenre() == genre) {
                    System.out.println(next);
                }
            }
        }
    }

    public void getListTop10() {
        TreeSet<Map.Entry<Integer, TreeSet<Film>>> entries = new TreeSet<>(new CompareRaiting());
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            System.out.println(entry);
        }
    }

    public static class CompareRaiting implements Comparator<Map.Entry<Integer, TreeSet<Film>>> {
        int result = 0;
        int result2 = 0;

        @Override
        public int compare(Map.Entry<Integer, TreeSet<Film>> o1, Map.Entry<Integer, TreeSet<Film>> o2) {
            Iterator<Film> iterator1 = o1.getValue().iterator();
            Iterator<Film> iterator2 = o2.getValue().iterator();
            while (iterator1.hasNext()) {
                Film next = iterator1.next();
                result = next.getRating();
            }
            while (iterator2.hasNext()) {
                Film next2 = iterator2.next();
                result2 = next2.getRating();
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "films=" + filmByYear +
                '}';
    }

}
