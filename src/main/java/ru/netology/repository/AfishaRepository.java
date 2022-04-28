package ru.netology.repository;
import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public void save(Movie movie) {
        // создаём новый массив размером на единицу больше, чем Movie[]
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        // копируем поэлементно все элементы из Movie[]
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        //добавляем последний элемент в Movie[]
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findById(int id) {
        Movie[] tmp=new Movie[]{};
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                tmp = new Movie[]{movie};
            }
        }
        movies=tmp;
        return movies;
    }

    public void removeById(int id) {
        // создаём новый массив размером на единицу меньше, чем Movie[]
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] tmp=new Movie[]{};
        movies=tmp;
    }


}