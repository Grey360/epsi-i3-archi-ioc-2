package utils;

import epsi.archi.ioc2.Movie;
import epsi.archi.ioc2.MovieService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Gets user input
 */
public class UserInput {

    public UserInput() {
        this.welcomeMessage();
    }

    public void choice(MovieService service){
        int choice = 0;
        System.out.println(
                "\n\tWhat do you want to do?"
                + "\n\t\t1 - Add a movie to the list."
                + "\n\t\t2 - Read a movie description from the list."
                + "\n\t\t3 - Update a movie description in the list."
                + "\n\t\t4 - Release a movie from the list."
        );
        choice = Integer.parseInt(new Scanner(System.in).nextLine());

        switch (choice){
            case 2:
                this.catchDate(service, new UserInput().catchRealisator());
                break;
            default:
                System.out.println("The feature is in development...");
                break;
        }
    }

    public static void welcomeMessage() {
        System.out.println("\n\t\t\t\tWelcome to the MOVIES SEARCH ENGINE! (Powered by Java)");
    }

    /**
     * We get the realisator
     *
     * @return
     */
    public String catchRealisator() {
        System.out.print("\n\tFirst, give us the name of a realisator, please: ");
        return new Scanner(System.in).nextLine();
    }

    /**
     * If the user is not capable of writing proper input,
     * we loop until death...
     *
     * @param service    MovieService
     * @param realisator String
     */
    public void catchDate(MovieService service, String realisator) {
        System.out.println("\n\tNow, a date using the following format, please: YYYY-MM-DD" +
                "\n\n\tFor instance:" +
                "\n\t\t- 1995, as year" +
                "\n\t\t- 08, as month" +
                "\n\t\t- 01, as day");

        List<Movie> listMovies = service.searchByRealisatorAndAfter(realisator, LocalDate.of(catchYear(), catchMonth(), catchDay()));
        if(listMovies.size() > 0){
            listMovies.forEach(m -> {
                System.out.println(
                        "----------------------------"
                        + "\n\tRealisator: " + m.getRealisator()
                        + "\n\tTitle: " + m.getTitle()
                        + "\n\tRelease Date: " + m.getReleaseDate()
                        + "\n\tCategory: " + m.getCategory()
                        + "\n\tDuration: " + m.getDuration()
                        + "\n\tExploitation number: " + m.getExploitationNumber()
                        + "\n----------------------------"
                );
                continueInput(service);
            });
        } else {
            System.out.println("\n\tNo movie matches this search! (Try another realisator or using an earlier date.) :/");
            continueInput(service);
        }
    }

    public void continueInput(MovieService service){
        System.out.print("\n\tDo you wish to continue? (Y or N)");
        if(new Scanner(System.in).nextLine().equals("Y")){
            UserInput userInput = new UserInput();
            userInput.choice(service);
        } else {
            System.out.println("Bye!");
        }
    }
    /**
     * We set the year
     *
     * @return
     */
    public static int catchYear() {
        int year = 0;
        String warning = "\n\t\tINPUT A VALID MONTH YEAR, PLEASE!";
        try {
            System.out.print("\t\tYear: ");
            year = Integer.parseInt(new Scanner(System.in).nextLine());

        } catch (NumberFormatException exception) {
            System.out.println(warning);
            return catchYear();
        }
        if (year > Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))) || year < 0) {
            System.out.println(warning);
            return catchYear();
        }
        return year;
    }

    /**
     * We set the month
     *
     * @return
     */
    public static int catchMonth() {
        int month = 0;
        String warning = "\n\t\tINPUT A VALID MONTH NUMBER, PLEASE!";
        try {
            System.out.print("\t\tMonth: ");
            month = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException exception) {
            System.out.println(warning);
            return catchMonth();
        }

        if (month > 12 || month < 1) {
            System.out.println(warning);
            return catchMonth();
        }
        return month;
    }

    /**
     * We set the day
     *
     * @return
     */
    public static int catchDay() {
        int day = 0;
        String warning = "\nINPUT A VALID DAY NUMBER, PLEASE!";
        try {
            System.out.print("\t\tDay: ");
            day = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException exception) {
            System.out.println(warning);
            return catchDay();
        }

        if (day > 31 || day < 1) {
            System.out.println(warning);
            return catchDay();
        }
        return day;
    }
}
