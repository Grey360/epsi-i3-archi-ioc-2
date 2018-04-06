package epsi.archi.ioc2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private MovieStorage storage;

    public MovieService(MovieStorage storage) {
        this.storage = storage;
    }

    public void add(Movie movie) {
        // TODO : check validity movie
        // TODO : Auto search duration
        storage.add(movie);
    }

    public void delete(String exploitationNumber) {
        storage.delete(exploitationNumber);
    }

    public List<Movie> searchByRealisatorAndAfter(String realisator, LocalDate after) {
        return storage.all().stream()
                .filter(m -> m.getRealisator().equals(realisator))
                .filter(m -> m.getReleaseDate().isAfter(after))
                .collect(Collectors.toList());
    }

    public void garbage(int minDuration) {
        storage.all().stream()
                .filter(m -> m.getDuration() < minDuration)
                .forEach(m -> storage.delete(m.getExploitationNumber()));
    }
}
