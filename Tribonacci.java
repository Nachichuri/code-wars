package com.codewars;

// Well met with Fibonacci bigger brother, AKA Tribonacci.
// As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to generate the next.
//So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this sequence:
//
// You need to create a fibonacci function that given a signature array/list, returns the first n elements - signature included of the so seeded sequence.
//
// Signature will always contain 3 numbers; n will always be a non-negative number.
// If n == 0, then return an empty array (except in C return NULL) and be ready for anything else which is not clearly specified ;)

public class Tribonacci {
    public static double[] tribonacciThis(double[] s, int n) {

        if (n == 0) {
            return new double[0];
        } else {
            double[] resultado = new double[n];

            // Appendeamos los valores que ya nos dieron
            try {
                for (int i = 0; i < s.length; i++)
                    resultado[i] = s[i];
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            // Aplicamos la lógica de fibonacci recursiva
            for (int i = 2; i < n - 1; i++)
                resultado[i + 1] = resultado[i] + resultado[i - 1] + resultado[i - 2];

            return resultado;
        }
    }
}

// Mejor solucion en CodeWars
//  public double[] tribonacci(double[] s, int n) {
//
//      double[] tritab=Arrays.copyOf(s, n); ! Al hacer un copy se evita tener que hacer un catch de la excepcion
//      for(int i=3;i<n;i++){
//        tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
//      }
//      return tritab;
//
//    }