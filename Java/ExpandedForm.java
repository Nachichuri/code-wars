package com.codewars.Java;

// Write Number in Expanded Form
// You will be given a number and you will need to return it as a string in Expanded Form. For example://
// Kata.expandedForm(42); # Should return "40 + 2"
// Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

public class ExpandedForm {
    public static String expandedForm(int num) {
        String resultado = "";

        for (int i = 10; i < num; i *= 10) {
            int resto = num % i;
            resultado = (resto > 0) ? " + " + resto + resultado : resultado; // I love you ternary operator
            num -= resto;
        }
        resultado = num + resultado;

        return resultado;
    }
}

// Tarea para otro dia: Hacer con Streams