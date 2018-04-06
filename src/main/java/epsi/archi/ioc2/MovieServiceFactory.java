package epsi.archi.ioc2;

import epsi.archi.ioc2.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MovieServiceFactory {

    MovieStorage storage;

    public MovieServiceFactory() {
        inMemoryStorage();
    }

    public void inMemoryStorage() {
        Movie movie = new Movie();
        movie.setTitle("Titanic");
        movie.setCategory("Drame");
        movie.setDuration(200);
        movie.setExploitationNumber("1234567890");
        movie.setRealisator("James Cameron");
        movie.setReleaseDate(LocalDate.of(1997, 10, 01));

        List<Movie> movies = Arrays.asList(movie);

        storage = new MovieStorageInMemory(movies);
    }

    public void jsonStorage() {
        new MovieJsonStorage("films.json");
    }

    public MovieService create() {
        return new MovieService(storage);
    }

}
