package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int countOutMovies = 10;

    public AfishaManager(AfishaRepository repository, int countOutMovies) {
        this.repository = repository;
        this.countOutMovies = countOutMovies;
    }

    public AfishaManager() {
    }

    public Movie[] getMoviesForFeed() {
        // TODO: add logic
        return null;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result;
        if (movies.length > countOutMovies) {
            result = new Movie[countOutMovies];
        } else {
            result = new Movie[movies.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Movie[] findById(int id) {
        Movie[] movies = repository.findById(id);
        return movies;
    }

    public void removeAll() {
        repository.removeAll();
    }
}