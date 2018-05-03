package epsi.archi.ioc2;

import java.time.LocalDate;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MovieServiceFactory factory = new MovieServiceFactory();
        factory.jsonStorage();

        MovieService service = factory.create();

        System.out.println("\t\t\tWelcome to Gailor's MOVIE SEARCH ENGINE!");
        System.out.print("\n\tFirst, give us the name of a realisator, please: ");
        String realisator = new Scanner(System.in).nextLine();

        catchDate(service, realisator);
    }

    /**
     * If the user is not capable of writing proper input,
     * we loop until death...
     * @param service MovieService
     * @param realisator String
     */
    public static void catchDate(MovieService service, String realisator){
        try {
            System.out.println("\nNow, a date using the following format, please: YYYY-MM-DD" +
                    "\nFor instance:" +
                    "\n     - 1995, as year" +
                    "\n     - 08, as month" +
                    "\n     - 01, as day");
            System.out.print("Year: ");
            int year = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.print("\nMonth: ");
            int month = Integer.parseInt(new Scanner(System.in).nextLine());
            System.out.print("\nDay: ");
            int day = Integer.parseInt(new Scanner(System.in).nextLine());

            service.searchByRealisatorAndAfter(realisator, LocalDate.of(year, month, day))
                    .forEach(m -> {
                        if(m.toString().isEmpty()){
                            System.out.println("This movie is not in our database! :/");
                        } else{
                            System.out.println(m);
                        }
                    });
        } catch (NumberFormatException exception){
            catchDate(service, realisator);
        }
    }
}
