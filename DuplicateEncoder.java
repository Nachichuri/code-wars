package com.codewars;

// The goal of this exercise is to convert a string to a new string where each character in the new string is:
// "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string.
// Ignore capitalization when determining if a character is a duplicate.
// Examples
// "din"      =>  "((("
// "recede"   =>  "()()()"

public class DuplicateEncoder {
    static String encode(String word){

        // Declaramos variables locales para hacer comparaciones y contar ocurrencias
        char[] letras = word.toLowerCase().toCharArray();
        int count = 0;
        String resultado = "";

        // Loopeamos y comparamos el item actual para ver cuantas ocurrencias tiene, O(n) though...
        for (int i = 0; i < letras.length; i++) {
            for (char letra : letras)
                count += (letra == letras[i]) ? 1 : 0;

            resultado += (count > 1) ? ")" : "(";
            count = 0;
        }

        return resultado;
    }
}

// Mejor resultado en CodeWars:
//  static String encode(String word){
//    word = word.toLowerCase();
//    String result = "";
//    for (int i = 0; i < word.length(); ++i) {
//      char c = word.charAt(i);
//      result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
//    }
//    return result;
// }
// Mejor que el mío porque yo itero sobre la lista entera O(n) cuando podría fijarme si la última ocurrencia es la actual O(1)