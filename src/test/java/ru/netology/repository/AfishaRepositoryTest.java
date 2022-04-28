package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {
    AfishaRepository repository=new AfishaRepository();
    Movie first = new Movie(1, "https://1", "bladshot", "ActionMovie");
    Movie second = new Movie(2, "https://2", "vpered", "Cartoon");
    Movie third = new Movie(3, "https://3", "belgrad", "Comedy");
    Movie fourth = new Movie(4, "https://4", "dgentelmens", "ActionMovie");
    Movie fifth = new Movie(5, "https://5", "men-inbisible", "Horror");
    Movie sixth = new Movie(6, "https://6", "trolly", "Cartoon");
    Movie seventh = new Movie(7, "https://7", "numberOne", "Comedy");
    Movie eighth = new Movie(8, "https://8", "Strelcov", "ActionMovie");
    Movie ninth = new Movie(9, "https://9", "describle-me", "Cartoon");
    Movie tenth = new Movie(10, "https://10", "vampire", "Horror");

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void shouldOutputAddMoviesFromAllList() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int idToFind=3;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNull() {
        int idToFind=13;
        Movie[] actual = repository.findById(idToFind);
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove=5;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first,second,third,fourth,sixth,seventh,eighth,ninth,tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}