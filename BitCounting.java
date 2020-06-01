package com.codewars;

// Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number.
// You can guarantee that input is non-negative.
// Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case

public class BitCounting {
    // Lo hacemos static para poder probarlo sin problemas desde Main
    public static int countBits(int n) {
        // Show me the code!
        byte count = 0;

        String binary = Integer.toBinaryString(n);

        for (char i : binary.toCharArray()) {
            if (Byte.parseByte(String.valueOf(i))!= 0)
                count++;
        }
        return count;
    }
}

// Resultado en CodeWars:
// Resulta que había un método para hacer específicamente eso T_T
//public static int countBits(int n){
//
//    return Integer.bitCount(n);
//}
