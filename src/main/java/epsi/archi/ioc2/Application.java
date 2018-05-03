package epsi.archi.ioc2;

import utils.UserInput;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        MovieServiceFactory factory = new MovieServiceFactory();
        factory.jsonStorage();

        MovieService service = factory.create();

        UserInput userInput = new UserInput();
        userInput.catchDate(service, userInput.catchRealisator());
    }


}
