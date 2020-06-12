package com.codewars;

// Simple transposition is a basic and simple cryptography technique.
// We make 2 rows and put first a letter in the Row 1, the second in the Row 2, third in Row 1 and so on until the end.
// Then we put the text from Row 2 next to the Row 1 text and thats it.
// Complete the function that recieves a string and encrypt it with this simple transposition.
// Example
//
// For example if the text to encrypt is: "Simple text", the 2 rows will be:
// Row 1 	S 	m 	l 		e 	t
// Row 2 	i 	p 	e 	t 	x
//
//So the result string will be: `"Sml etipetx"`

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Transposition {

    public static String simpleTransposition(String text) {
        ArrayList<Character> row1 = new ArrayList<>();
        ArrayList<Character> row2 = new ArrayList<>();

        for (int i = 0; i < text.length(); i++)
            if (i % 2 == 0)
                row1.add(text.charAt(i));
            else
                row2.add(text.charAt(i));

        return row1.stream().map(String::valueOf).collect(Collectors.joining()) +
                row2.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
