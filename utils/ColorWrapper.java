package utils;

public class ColorWrapper {
    // Text Colors
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

    // Background Colors
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
        switch (color.toUpperCase()) {
            case "BLACK":
                return BLACK + string + RESET;
            case "RED":
                return RED + string + RESET;
            case "GREEN":
                return GREEN + string + RESET;
            case "YELLOW":
                return YELLOW + string + RESET;
            case "BLUE":
                return BLUE + string + RESET;
            case "MAGENTA":
                return MAGENTA + string + RESET;
            case "CYAN":
                return CYAN + string + RESET;
            case "WHITE":
                return WHITE + string + RESET;
            case "BRIGHT_BLACK":
                return BRIGHT_BLACK + string + RESET;
            case "BRIGHT_RED":
                return BRIGHT_RED + string + RESET;
            case "BRIGHT_GREEN":
                return BRIGHT_GREEN + string + RESET;
            case "BRIGHT_YELLOW":
                return BRIGHT_YELLOW + string + RESET;
            case "BRIGHT_BLUE":
                return BRIGHT_BLUE + string + RESET;
            case "BRIGHT_MAGENTA":
                return BRIGHT_MAGENTA + string + RESET;
            case "BRIGHT_CYAN":
                return BRIGHT_CYAN + string + RESET;
            case "BRIGHT_WHITE":
                return BRIGHT_WHITE + string + RESET;
            default:
                throw new IllegalArgumentException("Invalid Color.");
        }
    }

    public String addBackgroundColor(String string, String color) {
        switch (color.toUpperCase()) {
            case "BLACK":
                return BACKGROUND_BLACK + string + RESET;
            case "RED":
                return BACKGROUND_RED + string + RESET;
            case "GREEN":
                return BACKGROUND_GREEN + string + RESET;
            case "YELLOW":
                return BACKGROUND_YELLOW + string + RESET;
            case "BLUE":
                return BACKGROUND_BLUE + string + RESET;
            case "MAGENTA":
                return BACKGROUND_MAGENTA + string + RESET;
            case "CYAN":
                return BACKGROUND_CYAN + string + RESET;
            case "WHITE":
                return BACKGROUND_WHITE + string + RESET;
            case "BRIGHT_BLACK":
                return BRIGHT_BACKGROUND_BLACK + string + RESET;
            case "BRIGHT_RED":
                return BRIGHT_BACKGROUND_RED + string + RESET;
            case "BRIGHT_GREEN":
                return BRIGHT_BACKGROUND_GREEN + string + RESET;
            case "BRIGHT_YELLOW":
                return BRIGHT_BACKGROUND_YELLOW + string + RESET;
            case "BRIGHT_BLUE":
                return BRIGHT_BACKGROUND_BLUE + string + RESET;
            case "BRIGHT_MAGENTA":
                return BRIGHT_BACKGROUND_MAGENTA + string + RESET;
            case "BRIGHT_CYAN":
                return BRIGHT_BACKGROUND_CYAN + string + RESET;
            case "BRIGHT_WHITE":
                return BRIGHT_BACKGROUND_WHITE + string + RESET;
            default:
                throw new IllegalArgumentException("Invalid Background Color.");
        }
    }
}
