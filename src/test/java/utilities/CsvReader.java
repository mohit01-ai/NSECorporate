package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public static String getCellData(String path, int row, int colm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            int currRow = 0;
            while ((line = reader.readLine()) != null) {
                if (currRow == row) {
                    String[] currData = line.split(",");
                    return currData[colm];
                }
                currRow++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}