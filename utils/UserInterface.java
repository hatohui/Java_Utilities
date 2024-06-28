package utils;

public class UserInterface {
    private String UI;

    /**
     * Constructor to create a new UserInterface.
     */
    public UserInterface() {
        this.UI = "";
    }

    /**
     * Set the UI to the given string.
     *
     * @param UI a String that consists the UI.
     */
    public void setUI(String UI) {
        this.UI = UI;
    }

    /**
     * Return a string that is the UI itself.
     *
     * @return a String that indicates the UI.
     */
    public String getUI() {
        return UI;
    }

    /**
     * Print out the UI to the console.
     */
    public void deploy() {
        for (int i = 0; i < 20; i++) System.out.println("\n");
        System.out.print(this.UI);
    }

}
