package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;
    Movie first = new Movie(1, "https://1", "bladshot", "ActionMovie");
    Movie second = new Movie(2, "https://2", "vpered", "Cartoon");
    Movie third = new Movie(3, "https://3", "belgrad", "Comedy");
    Movie fourth = new Movie(4, "https://4", "dgentelmens", "ActionMovie");
    Movie fifth = new Movie(5, "https://5", "men-inbisible", "Horror");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldOutput10LastAddMoviesFromAllList() {
        Movie sixth = new Movie(6, "https://6", "trolly", "Cartoon");
        Movie seventh = new Movie(7, "https://7", "numberOne", "Comedy");
        Movie eighth = new Movie(8, "https://8", "Strelcov", "ActionMovie");
        Movie ninth = new Movie(9, "https://9", "describle-me", "Cartoon");
        Movie tenth = new Movie(10, "https://10", "vampire", "Horror");
        Movie eleventh = new Movie(11, "https://11", "sharks", "Horror");
        Movie twelve = new Movie(12, "https://12", "Shadow", "Horror");
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelve);
        // настройка заглушки
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputLastAddMoviesFromAllListIfTheirLess10() {
        // настройка заглушки
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}