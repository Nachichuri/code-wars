package com.codewars;

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

