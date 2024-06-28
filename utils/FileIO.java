package utils;

import java.io.*;
import java.util.ArrayList;

public class FileIO extends ArrayList<String> {
    private static File file;

    /**Return an array containing the current state of data in the File.
     * @return an ArrayList<String> containing the current data in the file.
     * */
    public ArrayList<String> getCurrentState() {
        if (this.isEmpty())
            throw new IllegalStateException("there's no data in current state.");
        return this;
    }

    /**Constructor for FileIO
     * Used for adding urls
     * @param url the path to the file.
     * */
    public FileIO(String url) {
        file = new File(url);
        fetch();
    }

    public void fetch() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                this.add(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("File not found.");
            }
            System.out.println(e.getMessage());
        }
    }

    public void commit() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            for (String str : this) {
                writer.append(str);
            }
            writer.close();
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("File not found.");
            }
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> findInFileContaining(String value) {
        ArrayList<String> result = new ArrayList<>();
        for (String str: this) {
            if (str.toLowerCase().contains(value.toLowerCase())) {
                result.add(str);
            }
        }
        return result;
    }

    public void remove(String value) {
        for (String str: this) {
            if (str.strip().equalsIgnoreCase(value)) {
                this.remove(str);
            };
        }
    }

    public void append(String str) {
        this.add(str + "\n");
    }

    public String toString() {
        return String.join("", getCurrentState());
    }
}