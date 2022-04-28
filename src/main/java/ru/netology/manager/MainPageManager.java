package ru.netology.manager;
import ru.netology.domain.Movie;

public class MainPageManager {
    private AfishaManager afishaManager;

    /**
     * Main Page generation
     */
    public String generate() {
        Movie[] movies = afishaManager.getMoviesForFeed();
        // TODO: add logic
        for (Movie movie : movies) {
            String block = movie.getGenre();
        }
        return null;
    }
}