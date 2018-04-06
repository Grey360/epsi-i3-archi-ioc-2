package epsi.archi.ioc2;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface MovieStorage {

    List<Movie> all();

    Optional<Movie> get(String exploitationNumber);

    List<Movie> searchByTitle(String title);

    void add(Movie movie);

    void delete(String exploitatioNumber);
}
