package com.codewars.Java;

// Given a string of words, you need to find the highest scoring word.
// Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
// You need to return the highest scoring word as a string.
// If two words score the same, return the word that appears earliest in the original string.
// All letters will be lowercase and all inputs will be valid.

import java.util.ArrayList;
import java.util.Collections;

public class HighestScoringWord {
    public static String high(String s) {
        // Armamos un array con todas las palabras, e instanciamos un ArrayList para guardar los valores de cada palabra
        String[] palabras = s.split("\\s+");
        ArrayList<Integer> indexes = new ArrayList<>();
        // Empezamos a iterar sobre cada palabra en el array de palabras
        for (String palabra : palabras) {
            int sumaTotal = 0;
            for(int i=0; i< palabra.length(); i++){
                char letra = palabra.charAt(i);
                sumaTotal += ((int)letra - 96); // Magia negra
            }
            // Agregamos el valor de la palabra al ArrayList
            indexes.add(sumaTotal);
        }
        // Buscamos el index de la palabra con más valor y la devolvemos
        int target = indexes.indexOf(Collections.max(indexes));
        return palabras[target];
    }
}

// Mejor solucion en CodeWars:
// public static String high(String s) {
//    return Arrays.stream(s.split(" "))
//                .max(Comparator.comparingInt(
//                        a -> a.chars().map(i -> i - 96).sum()
//                )).get();
//  }