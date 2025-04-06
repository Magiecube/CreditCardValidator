/**
*@author <Olayemi Jean Clausius Odjetunde>
*@version <1.0>
*/

public class CreditCard {
    private final String number;

    /**
     * Constructs a CreditCard object with the specified card number.
     * @param number The credit card number.
     * @throws IllegalArgumentException if the provided number is invalid.
     */
    public CreditCard(String number) {
        // Validate the credit card number
        if (!isValidCreditCardNumber(number)) {
            throw new IllegalArgumentException("Invalid credit card number: " + number);
        }
        this.number = number;
    }

    /**
     * Validates a credit card number.
     * @param number The credit card number to validate.
     * @return True if the number is valid, false otherwise.
     */
    private boolean isValidCreditCardNumber(String number) {
        // Add validation logic here (e.g., length check, Luhn algorithm)
        // For simplicity, assuming all non-null numbers are valid
        return number != null;
    }

    /**
     * Retrieves the credit card number.
     * @return The credit card number.
     */
    public String getNumber() {
        return number;
    }
}

