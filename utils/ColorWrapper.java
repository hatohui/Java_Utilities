package utils;
import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String, String> colorMap = new HashMap<>();
    private static final Map<String, String> backgroundColorMap = new HashMap<>();

    static {
        colorMap.put("RESET", RESET);
        colorMap.put("BLACK", BLACK);
        colorMap.put("RED", RED);
        colorMap.put("GREEN", GREEN);
        colorMap.put("YELLOW", YELLOW);
        colorMap.put("BLUE", BLUE);
        colorMap.put("MAGENTA", MAGENTA);
        colorMap.put("CYAN", CYAN);
        colorMap.put("WHITE", WHITE);
        colorMap.put("BRIGHT_BLACK", BRIGHT_BLACK);
        colorMap.put("BRIGHT_RED", BRIGHT_RED);
        colorMap.put("BRIGHT_GREEN", BRIGHT_GREEN);
        colorMap.put("BRIGHT_YELLOW", BRIGHT_YELLOW);
        colorMap.put("BRIGHT_BLUE", BRIGHT_BLUE);
        colorMap.put("BRIGHT_MAGENTA", BRIGHT_MAGENTA);
        colorMap.put("BRIGHT_CYAN", BRIGHT_CYAN);
        colorMap.put("BRIGHT_WHITE", BRIGHT_WHITE);

        backgroundColorMap.put("BLACK", BACKGROUND_BLACK);
        backgroundColorMap.put("RED", BACKGROUND_RED);
        backgroundColorMap.put("GREEN", BACKGROUND_GREEN);
        backgroundColorMap.put("YELLOW", BACKGROUND_YELLOW);
        backgroundColorMap.put("BLUE", BACKGROUND_BLUE);
        backgroundColorMap.put("MAGENTA", BACKGROUND_MAGENTA);
        backgroundColorMap.put("CYAN", BACKGROUND_CYAN);
        backgroundColorMap.put("WHITE", BACKGROUND_WHITE);
        backgroundColorMap.put("BRIGHT_BLACK", BRIGHT_BACKGROUND_BLACK);
        backgroundColorMap.put("BRIGHT_RED", BRIGHT_BACKGROUND_RED);
        backgroundColorMap.put("BRIGHT_GREEN", BRIGHT_BACKGROUND_GREEN);
        backgroundColorMap.put("BRIGHT_YELLOW", BRIGHT_BACKGROUND_YELLOW);
        backgroundColorMap.put("BRIGHT_BLUE", BRIGHT_BACKGROUND_BLUE);
        backgroundColorMap.put("BRIGHT_MAGENTA", BRIGHT_BACKGROUND_MAGENTA);
        backgroundColorMap.put("BRIGHT_CYAN", BRIGHT_BACKGROUND_CYAN);
        backgroundColorMap.put("BRIGHT_WHITE", BRIGHT_BACKGROUND_WHITE);
    }


    /**Add color to the text of given String
     * @param string a String receiving colors
     * @param color a String that matches the colorCode
     * @return a String with color
     * @throws IllegalArgumentException when no color matches
     *          or when message is null
     * */
    public String addColor(String string, String color) {
        if (string.isEmpty()) throw new IllegalArgumentException("Argument passed is empty");
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

    /**Add background color to given String
     * @param string a String to display
     * @param color a String that matches the colorCode
     * @return a String with background color
     * @throws IllegalArgumentException when no color matches
     *          or when message is null
     * */
    public String addBackgroundColor(String string, String color) {
        if (string.isEmpty()) throw new IllegalArgumentException("Argument passed is empty");

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

    /**Add background color to given String
     * @param string a String to display
     * @param textColor String that matches the colorCode
     *                  for the text
     * @param backgroundColor String that matches the colorCode
     *                        for the background
     * @return a colored String with background color
     * @throws IllegalArgumentException when no color matches
     *          or when message is null
     * */
    public String addColor(String string, String textColor, String backgroundColor) {
        if (string.isEmpty()) throw new IllegalArgumentException("Argument passed is empty");

        String textColorCode;
        switch (textColor.toUpperCase()) {
            case "BLACK":
                textColorCode = BLACK;
                break;
            case "RED":
                textColorCode = RED;
                break;
            case "GREEN":
                textColorCode = GREEN;
                break;
            case "YELLOW":
                textColorCode = YELLOW;
                break;
            case "BLUE":
                textColorCode = BLUE;
                break;
            case "MAGENTA":
                textColorCode = MAGENTA;
                break;
            case "CYAN":
                textColorCode = CYAN;
                break;
            case "WHITE":
                textColorCode = WHITE;
                break;
            case "BRIGHT_BLACK":
                textColorCode = BRIGHT_BLACK;
                break;
            case "BRIGHT_RED":
                textColorCode = BRIGHT_RED;
                break;
            case "BRIGHT_GREEN":
                textColorCode = BRIGHT_GREEN;
                break;
            case "BRIGHT_YELLOW":
                textColorCode = BRIGHT_YELLOW;
                break;
            case "BRIGHT_BLUE":
                textColorCode = BRIGHT_BLUE;
                break;
            case "BRIGHT_MAGENTA":
                textColorCode = BRIGHT_MAGENTA;
                break;
            case "BRIGHT_CYAN":
                textColorCode = BRIGHT_CYAN;
                break;
            case "BRIGHT_WHITE":
                textColorCode = BRIGHT_WHITE;
                break;
            default:
                throw new IllegalArgumentException("Invalid Text Color.");
        }

        String backgroundColorCode;
        switch (backgroundColor.toUpperCase()) {
            case "BLACK":
                backgroundColorCode = BACKGROUND_BLACK;
                break;
            case "RED":
                backgroundColorCode = BACKGROUND_RED;
                break;
            case "GREEN":
                backgroundColorCode = BACKGROUND_GREEN;
                break;
            case "YELLOW":
                backgroundColorCode = BACKGROUND_YELLOW;
                break;
            case "BLUE":
                backgroundColorCode = BACKGROUND_BLUE;
                break;
            case "MAGENTA":
                backgroundColorCode = BACKGROUND_MAGENTA;
                break;
            case "CYAN":
                backgroundColorCode = BACKGROUND_CYAN;
                break;
            case "WHITE":
                backgroundColorCode = BACKGROUND_WHITE;
                break;
            case "BRIGHT_BLACK":
                backgroundColorCode = BRIGHT_BACKGROUND_BLACK;
                break;
            case "BRIGHT_RED":
                backgroundColorCode = BRIGHT_BACKGROUND_RED;
                break;
            case "BRIGHT_GREEN":
                backgroundColorCode = BRIGHT_BACKGROUND_GREEN;
                break;
            case "BRIGHT_YELLOW":
                backgroundColorCode = BRIGHT_BACKGROUND_YELLOW;
                break;
            case "BRIGHT_BLUE":
                backgroundColorCode = BRIGHT_BACKGROUND_BLUE;
                break;
            case "BRIGHT_MAGENTA":
                backgroundColorCode = BRIGHT_BACKGROUND_MAGENTA;
                break;
            case "BRIGHT_CYAN":
                backgroundColorCode = BRIGHT_BACKGROUND_CYAN;
                break;
            case "BRIGHT_WHITE":
                backgroundColorCode = BRIGHT_BACKGROUND_WHITE;
                break;
            default:
                throw new IllegalArgumentException("Invalid Background Color.");
        }

        return textColorCode + backgroundColorCode + string + RESET;
    }


    public static String getColor(String color) {
        return colorMap.getOrDefault(color, RESET);
    }

    public static String getBackground(String backgroundColor) {
        return backgroundColorMap.getOrDefault(backgroundColor, RESET);
    }
}
