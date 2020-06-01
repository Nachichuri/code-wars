package com.codewars;

// You might know some pretty large perfect squares. But what about the NEXT one?
// Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
// If the parameter is itself not a perfect square, than -1 should be returned. You may assume the parameter is positive.
// Examples:
// findNextSquare(121) --> returns 144
// findNextSquare(625) --> returns 676
// findNextSquare(114) --> returns -1 since 114 is not a perfect

public class NextSquare {
    public static long findNextSquare(long sq) {
        double raizCuadrada = Math.sqrt(sq);
        return (raizCuadrada % 1 == 0) ? (long)Math.pow((raizCuadrada+1), 2) : -1;
    }
}

// Resultado más votado en CodeWars:
// public static long findNextSquare(long sq) {
//    long root = (long) Math.sqrt(sq);
//    return root * root == sq ? (root + 1) * (root + 1) : -1;
// }