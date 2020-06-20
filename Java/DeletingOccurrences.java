package com.codewars.Java;

import java.util.*;

public class DeletingOccurrences {
// Enough is enough!
// Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
// For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2]
// since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
// Example
// DeletingOccurrences.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        // Creamos un HashMap usando los valores únicos como keys y los agregamos al ArrayList si la iteración no supera el maxOccurrences
        ArrayList<Integer> resultado = new ArrayList<>();
        HashMap<Integer, Integer> uniqueExtracted = new HashMap<>();
        // Usamos el método compute para chequear si el valor ya existe y en ese caso sumamos
        for (int i : elements) {
            uniqueExtracted.compute(i, (k,v)-> v == null ? 1 : v + 1);
            if (uniqueExtracted.get(i) <= maxOccurrences) {
                resultado.add(i);
            }
        }
        return resultado.stream().mapToInt(a->a).toArray();
    }
}

// Mejor solución en CodeWars:
// Usa el método merge con un stream, super clever
// public static int[] deleteNth(int[] elements, int maxOccurrences) {
//    Map<Integer, Integer> occurrence = new HashMap<>();
//    return IntStream.of(elements)
//      .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
//      .toArray();
//  }