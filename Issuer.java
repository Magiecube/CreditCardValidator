/**
*Description: This program will validates credit card numbers by using the Luhn Formula
*Class: <Spring - COSC 1437.82702 >
*Final Project
*Date: <05/09/2024>
*@author <Olayemi Jean Clausius Odjetunde>
*@version <1.0>
*/

import java.util.HashMap;
import java.util.Map;

public class Issuer {
    private static final Map<String, String> ISSUERS = new HashMap<>();

    static {
        ISSUERS.put("45", "VISA");
        ISSUERS.put("51", "MasterCard");
        ISSUERS.put("37", "American Express");
        ISSUERS.put("6011", "Discover");
        ISSUERS.put("637", "InstaPayment");
        ISSUERS.put("3528", "JCB");
        ISSUERS.put("6304", "Laser");
        ISSUERS.put("5018", "Maestro");
        ISSUERS.put("4", "Visa");
        ISSUERS.put("4026", "Visa Electron");
        ISSUERS.put("63", "InstaPayment");
    }

    public static String identifyIssuer(String cardNumber) {
        String prefix = cardNumber.substring(0, 4);

        if (ISSUERS.containsKey(prefix)) {
            return ISSUERS.get(prefix);
        } else {
            return "Unknown";
        }
    }
}

