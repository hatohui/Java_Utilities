package utils;

import java.util.Scanner;
import java.util.stream.Stream;

public class Display {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Generates a menu of options and get user's option.
     * (use printMenu for better UI)
     * <p>
     * Examples: for input <b>["foo","boo","woo"]</b>
     *  <br>1. foo
     *  <br>2. boo
     *  <br>3. woo
     *  <br>> Option: [your input]
     * @param items takes in an array of Strings that will be
     *              printed as a list of options
     * @return an integer ranging from 1 to the list's length that
     * indicates the option.
     * */
    public static int getOptions(String[] items) {
        int no = 1;
        for (String item : items) {
            System.out.println("\t" + no + "." + item);
            no++;
        }
        while (true) {
            try {
                System.out.print("> Option: ");
                int option = Integer.parseInt(scanner.nextLine());
                if (option > (no - 1) || option < 1)
                    throw new IllegalArgumentException("Please pick a proper option. (1-" + (no-1) + ")");
                return option;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Generates a loading bar: █████░░░░░░
     * <br>(change the source code if you want a different bar)
     * @param message - a string to display before the loading bar.
     * @param loadTime - an integer indicates amount of tick
     *                 for the loading bar.
     * @param interval - an integer that indicatses time period
     *                per tick (in milliseconds).
     * */
    public static void loadingBar(String message, int loadTime, int interval) {
        try {
            //setups
            char incomplete = '░';
            char completed = '█';
            StringBuilder builder = new StringBuilder();

            if (!message.isEmpty()) message += "\t";

            //generates the stream
            Stream.generate(() -> incomplete)
                    .limit(loadTime)
                    .forEach(builder::append);

            //loads
            for (int i = 0; i < loadTime; ++i) {
                builder.replace(i,i+1, java.lang.String.valueOf(completed));
                java.lang.String loading = "\r"+ message + builder;
                System.out.print(loading);
                Thread.sleep(interval);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void separator(char material, int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must > 0");
        StringBuilder builder = new StringBuilder();

        //generate the separator
        Stream.generate(() -> material)
                .limit(amount)
                .forEach(builder::append);

        System.out.println(builder);
    }

    public static void separator(char material) {
        separator(material, 70);
    }

    public static void separator() {
        separator('#', 70);
    }

    public static void printMenu(String title, String[] options) {
        separator();

    }
}
