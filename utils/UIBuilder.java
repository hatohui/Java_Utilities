package utils;

import java.util.stream.Stream;

/**
 * Consists of console commands for printing and creating console app's UIs.
 * @author hatohui
 * */
public class UIBuilder {
    //change here for components
    //loading
    private static final char completedLoading = '█';
    private static final char incompleteLoading = '░';
    //separators
    private static final char defaultMaterial = '═';
    //UI walls
    private static final char vertical = '║';
    private static final char topLeft = '╔';
    private static final char topRight = '╗';
    private static final char horizontal = '═';
    private static final char bottomLeft = '╚';
    private static final char bottomRight = '╝';
    //init
    private int horizontalLength = 70;

    /**
     * */
    public UIBuilder () {
    }

    /**Constructor for UIBuilder.
     * <p>If contain options for one letter needs at least 15 horizontal length.
     * Which increase by the length of the option's string.
     * @param horizontalLength an integer > 2 and <= 100 that indicates
     *                         the length of the UI horizontally
     * @throws IllegalArgumentException when the received integer is < 2 or > 100.
     * */
    public UIBuilder(int horizontalLength) {
        if (horizontalLength < 2 || horizontalLength >= 100)
            throw new IllegalArgumentException("size must be > 2 and <= 100");
        this.horizontalLength = horizontalLength;
    }

    /**
     * Print into the console an animated loading bar: █████░░░░░░
     * <br>(change the values in the source code if you want a different bar)
     * @param message - a string to display before the loading bar.
     * @param loadTime - an integer indicates amount of tick
     *                 for the loading bar.
     * @param interval - an integer that indicatses time period
     *                per tick (in milliseconds).
     * */
    public void loadingBar(String message, int loadTime, int interval) {
        try {
            StringBuilder builder = new StringBuilder();

            if (!message.isEmpty()) message += "\t";

            //generates the stream
            Stream.generate(() -> incompleteLoading)
                    .limit(loadTime)
                    .forEach(builder::append);

            //loads
            for (int i = 0; i < loadTime; ++i) {
                builder.replace(i,i+1, java.lang.String.valueOf(completedLoading));
                java.lang.String loading = "\r"+ message + builder;
                System.out.print(loading);
                Thread.sleep(interval);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Print a separator made of given character in desired length.
     *
     * @param material a character that the separator is made of.
     * @param amount    amount of material in the line.
     * @throws IllegalArgumentException when amount of material is <= 0.
    * */
    public void separator(char material, int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must > 0");

        StringBuilder builder = new StringBuilder();

        //generate the separator
        Stream.generate(() -> material)
                .limit(amount)
                .forEach(builder::append);

        System.out.print(builder);
    }

    /**
     * Print a separator made of given character.
     * Default length is 70.
     * @param  material a character that the separator is made of
     * */
    public void separator(char material) {
        separator(material, horizontalLength);
    }

    /**
     * Print a separator made of given character with default
     * length and default material in source.
     * */
    public void separator() {
        separator(defaultMaterial, horizontalLength);
    }

    /**Print the UIs ceiling into the console.
     * */
    public void topWall() {
        StringBuilder topWall = new StringBuilder();

        topWall.append(topLeft);

        Stream.generate(() -> horizontal)
                .limit(horizontalLength - 2)
                .forEach(topWall::append);

        topWall.append(topRight);

        System.out.println(topWall);
    }

    /**Print the UIs floor into the console.
     * */
    public void bottomWall() {
        StringBuilder bottomWall = new StringBuilder();

        bottomWall.append(bottomLeft);

        Stream.generate(() -> horizontal)
                .limit(horizontalLength - 2)
                .forEach(bottomWall::append);

        bottomWall.append(bottomRight);

        System.out.println(bottomWall);
    }

    /**Print a wall with two ends into the console.
     * */
    public void emptyWall() {
        StringBuilder emptyLine = new StringBuilder();

        emptyLine.append(vertical);
        Stream.generate(() -> ' ')
                .limit(horizontalLength - 2)
                .forEach(emptyLine::append);
        emptyLine.append(vertical);

        System.out.println(emptyLine);
    }

    /**Print a Header with given title into the console.
     * @param title a string that will be printed into the console.
     * @throws IllegalStateException when the title's length is too big compared
     * to the default horizontal length.
     * */
    public void header(String title) {
        int padding = (horizontalLength - 2 - title.length())/2;

        if (horizontalLength - 2 < title.length())
            throw new IllegalStateException("Title won't fit, title length is: "
                    + title.length() + " while we only have " + (horizontalLength - 2));

        StringBuilder header= new StringBuilder();

        header.append(vertical);
        Stream.generate(() -> ' ')
                .limit(padding)
                .forEach(header::append);
        header.append(title);

        if ((horizontalLength - title.length())%2==1) padding++;
        Stream.generate(() -> ' ')
                .limit(padding)
                .forEach(header::append);
        header.append(vertical);

        System.out.println(header);
    }

    /**Print a number of options wrapped by the walls within the UI.
     * <p></p>
     * @param options a String array containing options
     *                to be printed.
     * @throws IllegalArgumentException when options is empty or when
     * the passed argument is null.
     */
    public void options(String[] options) {
        //handle null
        if (options == null)
            throw new IllegalArgumentException("Passed argument is null.");

        //handle empty
        if (options.length == 0)
            throw new IllegalArgumentException("Passed String array can't be empty.");

        int count = 1;
        for (String option : options) {
            //initializes
            StringBuilder string = new StringBuilder();
            String opt= "[" + count + "]";

            //handle not enough space
            if ((horizontalLength - 2) < option.length())
                throw new IllegalStateException("The option's text length cannot fit" +
                        ", optLength is " + option.length() + " and horizontalLength is " +
                        (horizontalLength - 2));

            int padding = (horizontalLength - 2 - option.length()) / 2;

            //check if enough space to have option bar
            if (padding < 6)
                throw new IllegalStateException("Not enough length to fit in the option's text");

            int pad = padding/2;
            //building the string
            string.append(vertical);
            Stream.generate(() -> ' ')
                    .limit(pad - 3)
                    .forEach(string::append);

            string.append(opt);

            if (!(padding%2==0)) pad += 1;

            Stream.generate(() -> ' ')
                    .limit(pad)
                    .forEach(string::append);

            string.append(option);

            if ((horizontalLength - option.length()) % 2 == 1) padding++;
            Stream.generate(() -> ' ')
                    .limit(padding)
                    .forEach(string::append);
            string.append(vertical);

            System.out.println(string);
            count++;
        }
    }

    public void description(String description) {
        //todo
        //check null
        if (description.isEmpty())
            throw new IllegalArgumentException("Argument passed is empty or null, if you wanted" +
                    " an empty line use emptyWall");
        //initializes
        StringBuilder string = new StringBuilder();
        int padding = (horizontalLength - 2 - description.length())/2;

        //if longer then expected create new line;
        if (padding < 0) {
            return;
        }
        //
    }
}