package com.codewars.Java;

// If you're faced with an input box, like this:
//
//                                           +--------------+
//  Enter the price of the item, in dollars: |              |
//                                           +--------------+
//
// Inevitably, some people will type a $ sign and others will leave it out.
// So, we need a simple function that converts a string representing a number (possibly with a $ sign in front of it) into the number itself.
//
// Remember to consider negative numbers (the - sign may come either before or after the $ sign, if there is one), and any extraneous space characters
// (leading, trailing, or around the $ sign) that the users might put in. You do not need to handle trailing characters other than spaces (e.g. "1.2 3").
// If the given string does not represent a number, (either with or without a $ sign), return 0.0 .

public class UnwantedDollars {
        public static double moneyValue(String money){
            try {
                return Double.parseDouble(money.trim().replace("$", "").replace(" ", ""));
            } catch (NumberFormatException error) {
                return 0.0;
            }
        }
}

// Mejor solucion en CodeWars:
//    try {
//       return Double.parseDouble(money.replaceAll("[ $]", ""));
//    }
//    catch(NumberFormatException e) {
//      return 0.0;
//    }