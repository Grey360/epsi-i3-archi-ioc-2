package epsi.archi.ioc2;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        MovieServiceFactory factory = new MovieServiceFactory();
        factory.jsonStorage();

        MovieService service = factory.create();

        service.searchByRealisatorAndAfter("James Cameron", LocalDate.of(1995, 01, 01))
                .forEach(m -> System.out.println(m));

    }

}
