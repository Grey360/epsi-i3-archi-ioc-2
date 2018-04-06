package epsi.archi.ioc2;

import utils.JsonReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieJsonStorage implements MovieStorage {

    private List<Movie> movies;

    public MovieJsonStorage(String filePath) {
        JsonReader.readJsonFile(filePath, obj -> {
            Movie movie = new Movie();
            movie.setTitle(obj.getString("title"));
            movie.setRealisator(obj.getString("realisator"));
            movie.setExploitationNumber(obj.getString("exploitation"));
            movie.setDuration(obj.getInt("duration"));
            movie.setCategory(obj.getString("category"));
            movie.setReleaseDate(LocalDate.parse(obj.getString("release"), DateTimeFormatter.ISO_LOCAL_DATE));
            return movie;
        }).ifPresent(movies -> this.movies = movies);
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
