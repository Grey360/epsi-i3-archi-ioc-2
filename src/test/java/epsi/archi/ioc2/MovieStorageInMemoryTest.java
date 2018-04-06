package epsi.archi.ioc2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class MovieStorageInMemoryTest {

    @Test
    public void testGet() {
        MovieStorageInMemory storage = new MovieStorageInMemory(Arrays.asList());
        Optional<Movie> movie = storage.get("1452E51426512");
        movie.ifPresent(m -> System.out.println(m.getCategory()));

    }
}
