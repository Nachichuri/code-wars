package com.codewars.Java;

// Take 2 strings s1 and s2 including only letters from ato z.
// Return a new sorted string, the longest possible, containing distinct letters, each taken only once - coming from s1 or s2.
//
// Example:
// a = "xyaabbbccccdefww"
// b = "xxxxyyyyabklmopq"
// longest(a, b) -> "abcdefklmopqwxy"
//
// a = "abcdefghijklmnopqrstuvwxyz"
// longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

import java.util.stream.Collectors;

public class TwoToOne {

    public static String longest(String s1, String s2) {
        // Streams FTW
        String stringsUnidas = s1 + s2;

        String letrasUnicas = stringsUnidas.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        String stringOrdenada = letrasUnicas.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return stringOrdenada;
    }
}

// Mejor solucion de CodeWars
// public static String longest (String s1, String s2) {
//        String s = s1 + s2;
//        return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//    }