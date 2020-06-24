package com.br.random;

public class MaskCreditCard {
    public static void main(String[] args) {
        String creditCardNumber = "1312-312-31faf2";
        System.out.println(maskify(creditCardNumber));
    }

    public static String maskify(String creditCardNumber) {
        char maskingCharacter = '#';
        // No masking needed if the length is less than 6 characters
        if (creditCardNumber.length() >= 6) {
            // Converting string to array of characters so that logic can be applied easily
            char[] arrayOfCharacters = creditCardNumber.toCharArray();
            // Starting masking from index 1 as no masking needed for first character
            int firstMaskingIndex = 1;
            // Ending masking at index excluding last 4 characters
            int lastMaskingIndex = arrayOfCharacters.length - 4 - 1;
            for (int i = firstMaskingIndex; i <= lastMaskingIndex; i++) {
                if(Character.isDigit(arrayOfCharacters[i])) {
                    // Replacing digits with masking character
                    arrayOfCharacters[i] = maskingCharacter;
                }
            }
            // Converting array of characters back to a String
            return new String(arrayOfCharacters);
        } else {
            return creditCardNumber;
        }
    }
}
