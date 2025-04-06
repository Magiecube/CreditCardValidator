/*
@author  Olayemi Odjetunde

@version 1.0.0

This class is used by CreditCardValidatorApp.java, which contains the main method.

*/

public class CreditCardValidator {
    /**
     * Validates a credit card number using the Luhn algorithm.
     *
     * @param cardNumber The credit card number to validate.
     * @return True if the card number is valid, false otherwise.
     * @throws IllegalArgumentException if the input contains non-digit characters.
     */
    public static boolean validate(String cardNumber) {
        // Remove all non-digit characters from the card number
        String digitsOnly = cardNumber.replaceAll("\\D", "");

        // Check if the input contains non-digit characters
        if (!cardNumber.equals(digitsOnly)) {
            throw new IllegalArgumentException("Invalid input: non-digit characters found.");
        }

        // Convert the card number string to an array of integers
        int[] digits = new int[digitsOnly.length()];
        for (int i = 0; i < digitsOnly.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(digitsOnly.charAt(i)));
        }

        // Double every second digit from right to left
        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int doubledDigit = digits[i] * 2;
            if (doubledDigit > 9) {
                doubledDigit -= 9;
            }
            digits[i] = doubledDigit;
        }

        // Sum all the digits
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        // If the sum is a multiple of 10, the card number is valid
        return sum % 10 == 0;
    }
}


