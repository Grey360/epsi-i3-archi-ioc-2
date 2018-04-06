package epsi.archi.ioc2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieStorageInMemory implements MovieStorage {

    private List<Movie> movies;

    public MovieStorageInMemory(List<Movie> movies){
        this.movies = movies;
    }

    public List<Movie> all() {
        return Collections.unmodifiableList(movies);
    }

    public Optional<Movie> get(String exploitationNumber) {
        /*
        Optional<Movie> result = Optional.empty();
        for (Movie movie: movies) {
            if (movie.getExploitationNumber().equals(exploitationNumber)) {
                result = Optional.of(movie);
            }
        }
        return result;
        */
        return movies.stream()
                .filter(m -> m.getExploitationNumber().equals(exploitationNumber))
                .findFirst();
    }

    public List<Movie> searchByTitle(String title) {
        return movies.stream()
                .filter(m -> m.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public void add(Movie movie) {
        if (!get(movie.getExploitationNumber()).isPresent()) {
            movies.add(movie);
        }
    }

    public void delete(String exploitatioNumber) {
        get(exploitatioNumber).ifPresent(m -> movies.remove(m));
    }
}




