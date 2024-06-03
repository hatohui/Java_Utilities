package utils;

/*NOTES
Each color is 5 in length.
Each Bright variant is 7 in length.
A reset is 4 in length.
* */

public class ColorWrapper {
    //textColors
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    private static final String BRIGHT_BLACK = "\u001B[30;1m";
    private static final String BRIGHT_RED = "\u001B[31;1m";
    private static final String BRIGHT_GREEN = "\u001B[32;1m";
    private static final String BRIGHT_YELLOW = "\u001B[33;1m";
    private static final String BRIGHT_BLUE = "\u001B[34;1m";
    private static final String BRIGHT_MAGENTA = "\u001B[35;1m";
    private static final String BRIGHT_CYAN = "\u001B[36;1m";
    private static final String BRIGHT_WHITE = "\u001B[37;1m";

    private static final String BACKGROUND_BLACK = "\u001B[40m";
    private static final String BACKGROUND_RED = "\u001B[41m";
    private static final String BACKGROUND_GREEN = "\u001B[42m";
    private static final String BACKGROUND_YELLOW = "\u001B[43m";
    private static final String BACKGROUND_BLUE = "\u001B[44m";
    private static final String BACKGROUND_MAGENTA = "\u001B[45m";
    private static final String BACKGROUND_CYAN = "\u001B[46m";
    private static final String BACKGROUND_WHITE = "\u001B[47m";

    private static final String BRIGHT_BACKGROUND_BLACK = "\u001B[40;1m";
    private static final String BRIGHT_BACKGROUND_RED = "\u001B[41;1m";
    private static final String BRIGHT_BACKGROUND_GREEN = "\u001B[42;1m";
    private static final String BRIGHT_BACKGROUND_YELLOW = "\u001B[43;1m";
    private static final String BRIGHT_BACKGROUND_BLUE = "\u001B[44;1m";
    private static final String BRIGHT_BACKGROUND_MAGENTA = "\u001B[45;1m";
    private static final String BRIGHT_BACKGROUND_CYAN = "\u001B[46;1m";
    private static final String BRIGHT_BACKGROUND_WHITE = "\u001B[47;1m";

    public String addColor(String string, String color) {
        return switch (color.toUpperCase()) {
            case "BLACK" -> BLACK + string + RESET;
            case "RED" -> RED + string + RESET;
            case "GREEN" -> GREEN + string + RESET;
            case "YELLOW" -> YELLOW + string + RESET;
            case "BLUE" -> BLUE + string + RESET;
            case "MAGENTA" -> MAGENTA + string + RESET;
            case "CYAN" -> CYAN + string + RESET;
            case "WHITE" -> WHITE + string + RESET;
            case "BRIGHT_BLACK" -> BRIGHT_BLACK + string + RESET;
            case "BRIGHT_RED" -> BRIGHT_RED + string + RESET;
            case "BRIGHT_GREEN" -> BRIGHT_GREEN + string + RESET;
            case "BRIGHT_YELLOW" -> BRIGHT_YELLOW + string + RESET;
            case "BRIGHT_BLUE" -> BRIGHT_BLUE + string + RESET;
            case "BRIGHT_MAGENTA" -> BRIGHT_MAGENTA + string + RESET;
            case "BRIGHT_CYAN" -> BRIGHT_CYAN + string + RESET;
            case "BRIGHT_WHITE" -> BRIGHT_WHITE + string + RESET;
            default -> throw new IllegalArgumentException("Invalid Color.");
        };
    }
}
