package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**A tool for building UI at your convenience.
 * @author hatohui
 * @version 1.0.0
 * */
public class UIBuilder {
    private final UIComponents Compo = new UIComponents();
    private final ColorWrapper Color = new ColorWrapper();
    private UserInterface UI;
    private ArrayList<String> currentUI = new ArrayList<>();

    /**Default constructor which create a
     * new empty UserInterface by default.
     * UI by default have the size of 70.
     * */
    public UIBuilder() {
        this.UI = new UserInterface();
    }

    /**Constructor for UIBuilder, takes one parameter
     * and create a new empty User Interface.
     * @param horizontalLength set the horizontal length
     *                         of the said UI.
     * */
    public UIBuilder(int horizontalLength) {
        this.UI = new UserInterface();
        Compo.setHorizontalLength(horizontalLength);
    }

    /* UTILIZING UI COMPONENTS */

    /**Set the size of the UI to a new given size
     * @param horizontal an integer that the size
     *                   of the UI is set to.
     * */
    public UIBuilder setSize(int horizontal) {
        Compo.setHorizontalLength(horizontal);
        return this;
    }

    /**Print an animated loading bar onto the console.
     * @param message a String that is displayed
     *                before the loading.
     * @param ticks number of ticks for the loading bar.
     * @param interval defines the time in between the ticks.
     * */
    public UIBuilder loader(String message, int ticks, int interval) {
        Compo.loadingBar(message, ticks, interval);
        return this;
    }

    /**Add a header for your UI displaying the given text
     * in the middle.
     * @param name a String to be displayed.
     * */
    public UIBuilder header(String name) {
        currentUI.add(Compo.header(name) + "\n");
        return this;
    }

    /**Add the top wall (ceiling) for your UI.
     * */
    public UIBuilder topWall() {
        currentUI.add(Compo.topWall() + "\n");
        return this;
    }

    /**Add a separator line to your UI.
     * */
    public UIBuilder separator() {
        currentUI.add(separator() + "\n");
        return this;
    }

    /**Add a separator line to your UI made of given
     * material.
     * @param material a char symbol constructing the separator.
     * */
    public UIBuilder separator(Character material) {
        currentUI.add(Compo.separator(material) + "\n");
        return this;
    }

    /**Add the bottom wall String (floor) to your UI.
     * */
    public UIBuilder bottomWall() {
        currentUI.add(Compo.bottomWall() + "\n");
        return this;
    }

    /**Add an empty space with two walls on the side to
     * your UI.
     * */
    public UIBuilder emptyWall() {
        currentUI.add(Compo.emptyWall() + "\n");
        return this;
    }

    /**Add a certain amount of options to your UI for display.
     * Amount is indicated by the length of the String array passed.
     * @param options a String array containing the options to be
     *                printed.
     * */
    public UIBuilder options(String[] options) {
        currentUI.add(Compo.options(options) + "\n");
        return this;
    }

    /**Add an option bar using a custom button text and the description
     * of the option to the UI.
     * @param buttonText a String to display on the button
     * @param optionText a String to what the option is for
     * */
    public UIBuilder option(String buttonText, String optionText) {
        currentUI.add(Compo.option(buttonText, optionText) + "\n");
        return this;
    }

    /**Add a block displaying the given text to the UI. The
     * distance from the UI's walls to the String is given.
     * @param padding an integer displaying the distance from
     *                the wall to the content
     * @param text a String to display.
     * */
    public UIBuilder description(String text, int padding) {
        currentUI.add(Compo.description(text, padding) + "\n");
        return this;
    }

    /**Add a String to be displayed along with a text
     * closer to the left, the distance is decided with the
     * padding given.
     * @param text a String to be displayed.
     * @param padding an integer indicating the distance from the
     *                left wall to its content.
     * */
    public UIBuilder leftString(String text, int padding) {
        currentUI.add(Compo.leftString(text, padding) + "\n");
        return this;
    }

    /**Add a String to be displayed along with a text
     * closer to the right, the distance is decided with the
     * padding given.
     * @param text a String to be displayed.
     * @param padding an integer indicating the distance from the
     *                right wall to its content.
     * */
    public UIBuilder rightString(String text, int padding) {
        currentUI.add(Compo.rightString(text, padding) + "\n");
        return this;
    }

    //FUNCTIONALITY
    /**Reset the UIBuilder, wipes all data so the UI
     * return to its initial state.
     */
    public void reset() {
        UI = new UserInterface();
        currentUI.clear();
    }

    /**Return the UserInterface Object containing data of your
     * preset Interface then RESET the UIBuilder to its original
     * state. All data are wiped.
     * @return an UserInterface object
     * */
    public UserInterface saveAndReset() {
        UserInterface value = new UserInterface();
        value.setUI(String.join("",currentUI));
        UI = new UserInterface();
        currentUI.clear();
        return value;
    }

    /**Store the UI given to the current UserInterface
     * object then reset the data in the UIBuilder. If you wish
     * to access or restore the data use load()
     * */
    public UIBuilder save() {
        UI.setUI(String.join("",currentUI));
        currentUI.clear();
        return this;
    }

    /**Load the UI into the current data in the builder
     * for further operations. Usually used to load presets.
     * */
    public UIBuilder load() {
        String[] values = UI.getUI().split("\n");
        for (String value: values) {
            currentUI.add(value + "\n");
        }
        return this;
    }

    /**Save the UI into the UserInterface object and return it.
     * @return UserInterface object
     * */
    public UserInterface saveAndReturn() {
        UI.setUI(String.join("",currentUI));
        return UI;
    }

    /**Set the current UserInterface object that UIBuilder
     * is functioning on to a different one.
     * */
    public UIBuilder use(UserInterface newUI) {
        UI = newUI;
        return this;
    }

    /**Print out the current state of the UI data in the Builder
     * object to the console. Used for debugging.
     * */
    public void build() {
        System.out.print(currentUI);
    }

    /**Adding color into your components sparing the border.
     *@param color to add Color into the prior text. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * */
    public UIBuilder withColor(String color) {
        String vertical = String.valueOf(UIComponents.getVertical());
        StringBuilder newString = new StringBuilder();

        String[] parts = currentUI.getLast()
                .split(vertical);

        for (String part: parts) {
            if (part.length() <= 1) continue;
            newString.append(vertical)
                .append(Color.addColor(part, color))
                .append(vertical).append("\n");
        }

        currentUI.removeLast();
        currentUI.add(newString.toString());

        return this;
    }

    /**Adding color into your components sparing the border.
     * @param color to add Color into the prior text. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * @param background to add Color into the background of component. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * */
    public UIBuilder withColor(String color, String background) {
        String vertical = String.valueOf(UIComponents.getVertical());
        StringBuilder newString = new StringBuilder();

        String[] parts = currentUI.getLast()
                .split(vertical);

        for (String part: parts) {
            if (part.length() <= 1) continue;
            newString.append(vertical)
                    .append(Color.addColor(part, color, background))
                    .append(vertical).append("\n");
        }

        currentUI.removeLast();
        currentUI.add(newString.toString());

        return this;
    }

    /**Set the color for the border before creating the UI
     * This might not work with some special symbols.
     * */
    public UIBuilder setBorderColor(String color) {
        UIComponents.setBottomLeft(Color.addColor(
                String.valueOf(UIComponents.getBottomLeft()), color).charAt(0));
        UIComponents.setBottomRight(Color.addColor(
                String.valueOf(UIComponents.getBottomRight()), color).charAt(0));
        UIComponents.setHorizontal(Color.addColor(
                String.valueOf(UIComponents.getHorizontal()), color).charAt(0));
        UIComponents.setVertical(Color.addColor(
                String.valueOf(UIComponents.getVertical()), color).charAt(0));
        UIComponents.setTopLeft(Color.addColor(
                String.valueOf(UIComponents.getTopLeft()), color).charAt(0));
        UIComponents.setTopRight(Color.addColor(
                String.valueOf(UIComponents.getTopRight()), color).charAt(0));
        return this;
    }


    /**Adding color into your components including the border.
     * @param color to add Color into the prior text. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * */
    public UIBuilder withColorIncludingBorder(String color) {
        String toAddColor = currentUI.getLast();
        toAddColor = Color.addColor(toAddColor, color);
        currentUI.removeLast();
        currentUI.add(toAddColor);
        return this;
    }

    /**Adding color into your components including the border.
     * @param color to add Color into the prior text. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * @param background to add Color into the background of component. Available colors
     *             includes BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN
     *             ,WHITE.
     * */
    public UIBuilder withColorIncludingBorder(String color, String background) {
        String toAddColor = currentUI.getLast();
        toAddColor = Color.addColor(toAddColor, color);
        toAddColor = Color.addBackgroundColor(toAddColor,color);
        currentUI.removeLast();
        currentUI.add(toAddColor);
        return this;
    }
}
