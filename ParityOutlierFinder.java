package com.codewars;

// You are given an array (which will have a length of at least 3, but could be very large) containing integers.
// The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
// Write a method that takes the array as an argument and returns this "outlier" N.
// Examples
// [2, 4, 0, 100, 4, 11, 2602, 36] should return: 11 (the only odd number)
// [160, 3, 1719, 19, 11, 13, -21] should return: 160 (the only even number)

public class ParityOutlierFinder {
    static int find(int[] integers) {
        int count = 0;
        int par = 0;
        int impar = 0;

        for (int numero : integers)
            if (numero % 2 == 0) {
                par = numero;
                count++;
            } else {
                impar = numero;
            }

        return (count == 1) ? par: impar;
    }
}

// Mejor solución CodeWars:
//  int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
//  int mod = (sum == 0 || sum == 1) ? 1 : 0;
//
//  return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
//         .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
