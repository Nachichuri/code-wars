package com.codewars;

// Your task is to create a function that turns a string into a Mexican Wave.
// You will be passed a string and you must return that string in an array where an uppercase letter is a person standing up.
// Rules
// 1.  The input string will always be lower case but maybe empty.
// 2.  If the character in the string is whitespace then pass over it as if it was an empty seat.
// Example: wave("hello") => []string{"Hello", "hEllo", "heLlo", "helLo", "hellO"}

import java.util.ArrayList;

public class MexicanWave {
    public static String[] wave(String str) {

        ArrayList<String> daWave = new ArrayList<>();

        char[] letras = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (letras[i] == ' ') {
            }
            else {
                letras[i] = Character.toUpperCase(letras[i]);
                daWave.add(new String(letras));
                letras = str.toCharArray();
            }
        }

        return daWave.toArray(new String[0]);
    }
}
