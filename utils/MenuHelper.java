package utils;

import java.util.Scanner;

public class MenuHelper {
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
}
