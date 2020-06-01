package com.codewars;

// ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
// If the function is passed a valid PIN string, return true, else return false.
// eg:
// Solution.validatePin("1234") === true
// Solution.validatePin("12345") === false
// Solution.validatePin("a234") === false

public class ATMPin {
    public static boolean validatePin(String pin) {
        try {
            int parsedInt = Integer.parseInt(pin);
            if (pin.matches("\\+.*") || parsedInt < 0)
                return false;
            else
                pin = pin.replaceAll("\\D+","");
            return pin.length() == 4 || pin.length() == 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

// Resultado en CodeWars:
// Tenes que ser un RegEx master
// public static boolean validatePin(String pin) {
//     return pin.matches("\\d{4}|\\d{6}");
// }