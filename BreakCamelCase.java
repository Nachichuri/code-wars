package com.codewars;

// Complete the solution so that the function will break up camel casing, using a space between words.
// Example
//
// solution("camelCasing")  ==  "camel Casing"

public class BreakCamelCase {
    public static String camelCase(String input) {
        String result = "";

        for (char item : input.toCharArray())
            result += (Character.isUpperCase(item)) ? " " + item : item;

        return result;
    }
}

// Mejor respuesta en CodeWars:
//  public static String camelCase(String input) {
//    return input.replaceAll("([A-Z])", " $1");
//  }