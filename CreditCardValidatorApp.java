/**
*Description: This program will validates credit card numbers by using the Luhn Formula
*
* How to Run:
* 1. Open a terminal or command prompt.
* 2. Navigate to the directory containing CreditCardValidatorApp.java.
* 3. Compile the program: javac CreditCardValidatorApp.java
* 4. Run the program: java CreditCardValidatorApp credit_card_numbers.txt
*
*@author <Olayemi Jean Clausius Odjetunde>
*@version <1.0>
*/

import java.io.*;
import java.util.*;

public class CreditCardValidatorApp {
    public static void main(String[] args) {
        // Explanation to the user
        System.out.println("This is an application that validates credit card numbers in the context of an investigation.\n");

        // Ask the user whether to proceed with validation
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to validate credit card numbers (yes/no)? ");
        String userInput = scanner.nextLine().trim().toLowerCase();

        if (!userInput.equals("yes")) {
            System.out.println("End of the program!");
            return;
        }

        // Proceed with validation
        if (args.length < 1) {
            System.err.println("Usage: java CreditCardValidatorApp <path_to_input_file>");
            return;
        }

        String inputFile = args[0];

        List<String> creditCardNumbers = readFromFile(inputFile);

        if (creditCardNumbers.isEmpty()) {
            System.out.println("No credit card numbers found in the input file.");
            return;
        }

        // Validate credit card numbers
        List<String> validCards = new ArrayList<>();
        List<String> invalidCards = new ArrayList<>();
        for (String number : creditCardNumbers) {
            if (CreditCardValidator.validate(number)) {
                validCards.add(number);
            } else {
                invalidCards.add(number);
            }
        }

        // Write results to output files
        try {
            FileHandler.writeToFile("valid_cards.txt", validCards);
            FileHandler.writeToFile("invalid_numbers.txt", invalidCards);
            System.out.println("The validation process has been completed. Check 'valid_cards.txt' and 'invalid_numbers.txt' for the results.");
        } catch (IOException e) {
            System.err.println("Error writing to output files: " + e.getMessage());
        }
    }

    private static List<String> readFromFile(String filename) {
        List<String> creditCardNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                creditCardNumbers.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return creditCardNumbers;
    }
}



