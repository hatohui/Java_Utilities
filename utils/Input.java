package utils;

import java.util.Scanner;

/**
 * Utility for getting inputs, data passed will
 * get checked for null, validity before returned to a value.
 * <p>
 * The code follows a certain formatting, change the source
 * code if you want your own style of inputs.
 */
public class Input {
    //scanner
    private static final Scanner scanner = new Scanner(System.in);

    /* HANDLE STRINGS*/

    private static String getString(String message, boolean allowSpecial, String regex) {
        //message
        if (message == null)
            throw new IllegalArgumentException("No message found.");

        //getInput
        while (true) {
            try {
                System.out.print("> " + message + ": ");
                String str = scanner.nextLine().trim();

                //check null
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Input can't be empty, try again.");
                }

                //check contain any special symbols
                if (!allowSpecial)
                    if (!str.matches("\\w+"))
                        throw new IllegalArgumentException("Input can only " +
                                "contain letters, numbers and '_', try again.");

                //check regex
                if (regex != null) {
                    if (!str.matches(regex))
                        throw new IllegalArgumentException("Input wrong format.");
                }

                return str;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Return a string after printing details on what to input
     * to the console. The String inputted can only contain
     * letters [a-z][A-Z], numbers [0-9], and '_' by default. You
     * can change this by adding a true parameter.
     * <p>
     *     <i><b>Example: Input.getString("foo", true);</b></i>
     * <p>
     * The message will get printed in this form by default:
     * <br>
     *          <i><b>> [YourMessage]: [Input]</b></i>
     * @param message the string to display. if null throw
     *                illegalArgumentException.
     * @return - a string containing only letters a-z, A-Z, numbers
     * 0-9 and '_'
     * @throws IllegalArgumentException when no message found.
     */
    public static String getString(String message) {
        return getString(message, false, null);
    }

    /**
     * Return a string after printing details on what to input
     * to the console.
     * <p>
     * The message will get printed in this form by default:
     * <br>
     *          <i><b> [YourMessage]: [Input]</b></i>
     * <p>
     * @param message the string to display. if null throw
     *                illegalArgumentException.
     * @param allowSpecial set true to allow special symbols on the string,
     *              you can remove or set this parameter to false
     *              if special symbols are unwanted.
     * @return a string including special symbols.
     * @throws IllegalArgumentException when no message found.
     */
    public static String string(String message, boolean allowSpecial) {
        return getString(message, allowSpecial, null);
    }

    /**
     * Return a string after printing details on what to input
     * and checking whether the input matches given regex to the console.
     * <p>
     * The message will get printed in this form by default:
     * <br>
     *          <i><b> [YourMessage]: [Input]</b></i>
     * <p>
     * @param message the string to display. if null throws
     *                illegalArgumentException.
     * @param regex takes in regex that force the input to match.
     * @return a string formatted with the regex given
     * @throws IllegalArgumentException when no message found.
     */
    public static String getString(String message, String regex) {
        return getString(message, true, regex);
    }

    /* HANDLE NUMBERS*/

    /* INTEGERS */

    /**
     * Return an integer after printing details on what to
     * input. Checking the range from floor to ceiling
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param floor the lower bound of the integer expected.
     * @param ceiling the upper bound of the integer expected.
     * @return an integer within the range given
     * @throws IllegalArgumentException when no message was given
     */
    public static int getInteger(String message, int floor, int ceiling) {
        //print message
        if (message == null)
            throw new IllegalArgumentException("No message found.");

        //check valid floor and ceiling
        if (floor > ceiling) {
            throw new IllegalArgumentException("Floor must be lower than ceiling");
        } else if ((floor != 0 || ceiling != 0) && floor == ceiling) {
            throw new IllegalArgumentException(("Floor must < than ceiling"));
        }

        //getInput
        while (true) {
            try {
                System.out.print("> " + message + ": ");
                int number = Integer.parseInt(scanner.nextLine());

                //check range
                if (!(floor == 0 && ceiling == 0)) {
                    if (number < floor || number > ceiling)
                        throw new IllegalStateException("Number is in invalid range. The " +
                                "range is " + floor + " - " + ceiling);
                }

                return number;
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("Please input an integer.");
                } else System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Return an integer after printing details on what integer to
     * input with a bound.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param bound defines the range of expected integer.
     * <p>Example: <b><i>Input.getInteger("foo",10)</i></b></p> returns
     *              an integer from 0-10.
     * @return an integer ranging from 0 to the given bound.
     * @throws IllegalArgumentException when no message found.
     */
    public static int getInteger(String message, int bound) {
        return getInteger(message, 0, bound);
    }

    /**
     * Return an integer after printing details on what to
     * input.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @return an integer
     * @throws IllegalArgumentException when no message found.
     */
    public static int getInteger(String message) {
        return getInteger(message, 0, 0);
    }

    /* DOUBLE */
    /**
     * Return a double after printing details on what to
     * input. Checking the range from floor to ceiling
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param floor the lower bound of the double expected.
     * @param ceiling the upper bound of the double expected.
     * @return a double within the range given.
     * @throws IllegalArgumentException when no message found.
     */
    public static double getDouble(String message, double floor, double ceiling) {
        //print message
        if (message == null)
            throw new IllegalArgumentException("No message found.");

        //check valid floor and ceiling
        if (floor > ceiling) {
            throw new IllegalArgumentException("Floor must be lower than ceiling");
        } else if ((floor != 0 || ceiling != 0) && floor == ceiling) {
            throw new IllegalArgumentException(("Floor "));
        }

        //getInput
        while (true) {
            try {
                System.out.print("> " + message + ": ");
                double number = Double.parseDouble(scanner.nextLine());

                //check range
                if (!(floor == 0 && ceiling == 0)) {
                    if (number < floor || number > ceiling)
                        throw new IllegalStateException(String.format("Number is in" +
                                " invalid range. The range is %.2f - %.2f", floor, ceiling));
                }

                return number;
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("Please input a double.");
                } else System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Return a double after printing details on what double to
     * input with a bound.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param bound defines the range of expected double.
     * <p>Example: <b><i>Input.getDouble("foo",10.1)</i></b></p> returns
     *              a double from 0-10.1.
     * @return a double ranging from 0 to the given bound.
     * @throws IllegalArgumentException when no message found.
     */
    public static double getDouble(String message, int bound) {
        return getDouble(message, 0, bound);
    }

    /**
     * Return a double after printing details on what to
     * input.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @return a double
     * @throws IllegalArgumentException when no message is found
     */
    public static double getDouble(String message) {
        return getDouble(message, 0, 0);
    }

    /* FLOAT */
    /**
     * Return a float after printing details on what to
     * input. Checking the range from floor to ceiling
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param floor the lower bound of the float expected.
     * @param ceiling the upper bound of the float expected.
     * @return a float within the given range
     * @throws IllegalArgumentException when no message is found.
     */
    public static float getFloat(String message, float floor, double ceiling) {
        //print message
        if (message == null)
            throw new IllegalArgumentException("No message found.");

        //check valid floor and ceiling
        if (floor > ceiling) {
            throw new IllegalArgumentException("Floor must be lower than ceiling");
        } else if ((floor != 0 || ceiling != 0) && floor == ceiling) {
            throw new IllegalArgumentException(("Floor "));
        }

        //getInput
        while (true) {
            try {
                System.out.print("> " + message + ": ");
                float number = Float.parseFloat(scanner.nextLine());

                //check range
                if (!(floor == 0 && ceiling == 0)) {
                    if (number < floor || number > ceiling)
                        throw new IllegalStateException(String.format("Number is in" +
                                " invalid range. The range is %.2f - %.2f", floor, ceiling));
                }

                return number;
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("Please input a float.");
                } else System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Return a float after printing details on what float to
     * input with a bound.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @param bound defines the range of expected float.
     * <p>Example: <b><i>Input.getFloat("foo",10.1)</i></b></p> returns
     *              a float from 0-10.1.
     * @return a float ranging from 0 to the given bound
     * @throws IllegalArgumentException when no message is found
     */
    public static float getFloat(String message, int bound) {
        return getFloat(message, 0, bound);
    }

    /**
     * Return a float after printing details on what to
     * input.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @return a float
     * @throws IllegalArgumentException when no message is found
     */
    public static float getFloat(String message) {
        return getFloat(message, 0, 0);
    }

    /* CHARACTER */
    /**
     * Return the first character after printing details on what to
     * input.
     * <p>
     * @param message the string to display, if null throws
     *                illegalArgumentException
     * @return a character
     * @throws IllegalArgumentException when no message is found.
     */
    public static char getChar(String message) {

        if (message == null)
            throw new IllegalArgumentException("No message found.");

        while (true) {
            try {
                System.out.print("> " + message + ": ");
                return scanner.nextLine().trim().charAt(0);
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    System.out.println("Can't be empty, please input a character.");
                } else System.out.println(e.getMessage());
            }
        }
    }
}