package com.codewars;

// Create a function that takes a positive integer and returns the next bigger number that can be formed by rearranging its digits. For example:
// 513 ==> 531
// 2017 ==> 2071
// Revisar

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NextBiggerNumber {
    public static long next(long n) {
        // Está resuelto adentro de un solo método porque el foco está en el algoritmo y no en la modularidad
        // Vamos a trabajar con Ints para no trabajar con Longs
        // Podríamos trabajar con bytes pues [0-9] pero hay que castear mucho para loopear
        int nro = (int)n;
        // Armamos una Lista con cada numero del Long
        ArrayList<Integer> nros = new ArrayList<>();
        do{
            nros.add(0, nro % 10);
            nro /= 10;
        } while (nro > 0);

        // Convertimos el ArrayList a un Array normal
        int[] arrayNum = nros.stream().mapToInt(i->i).toArray();

        // Encontramos el punto en el que hay un nro mayor que el anterior
        int i = arrayNum.length - 1;
        while (i > 0 && arrayNum[i - 1] >= arrayNum[i])
            i--;

        // Si no lo encontramos significa que no podemos crear un valor más grande, cerramos el ejercicio acá:
        if (i <= 0)
            return -1;

        // En este caso arrayNum[i-1] es el index del valor que encontramos para cortar
        // Buscamos el valor a la derecha que lo exceda
        int j = arrayNum.length - 1;
        while (arrayNum[j] <= arrayNum[i - 1])
            j--;

        // Swapeamos el valor de quiebre por el mayor
        int pivote = arrayNum[i - 1];
        arrayNum[i - 1] = arrayNum[j];
        arrayNum[j] = pivote;

        // Reverseamos el restante hacia la derecha
        j = arrayNum.length - 1;
        while (i < j) {
            pivote = arrayNum[i];
            arrayNum[i] = arrayNum[j];
            arrayNum[j] = pivote;
            i++;
            j--;
        }
        // Devolvemos un solo Long
        return Long.parseLong(Arrays.stream(arrayNum)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}