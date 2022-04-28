package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int countOutMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int countOutMovies) {
        this.countOutMovies = countOutMovies;
    }

    public Movie[] getMoviesForFeed() {
        // TODO: add logic
        return null;
    }

    public void add(Movie movie) {
        // создаём новый массив размером на единицу больше, чем Movie[]
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        // копируем поэлементно все элементы из Movie[]
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        //добавляем последний элемент в Movie[]
        int LastIndex = tmp.length - 1;
        tmp[LastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] result;
        if (movies.length>countOutMovies) {
            result = new Movie[countOutMovies];
        }
        else {
            result = new Movie[movies.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}