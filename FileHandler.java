/*
@author  Olayemi Odjetunde

@version 1.0.0

This class is used by CreditCardValidatorApp.java, which contains the main method.

*/

import java.io.*;
import java.util.*;

class FileHandler {
    public static List<String> readFromFile(String filename) throws IOException {
        List<String> creditCardNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                creditCardNumbers.add(line.trim());
            }
        }
        return creditCardNumbers;
    }

    public static void writeToFile(String filename, List<String> content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
