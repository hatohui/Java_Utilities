package utils;

import java.io.*;

public class FileIO {
    private BufferedReader reader;
    private OutputStreamWriter writer;

    public FileIO(String url) {
        try {
            File file = new File(url);
            this.reader = new BufferedReader(new FileReader(file));
            this.writer = new OutputStreamWriter(new FileOutputStream(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readFile() {
        try {
            StringBuilder result = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                result.append(line);
                line = reader.readLine();
            }
            return result.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean writeToFile(String value) {
        try {
            writer.append(value)
                    .append("\n");
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}