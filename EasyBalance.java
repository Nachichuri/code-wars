package com.codewars;

// You are given a (small) check book as a - sometimes - cluttered (by non-alphanumeric characters) string:
//  "1000.00
//  125 Market 125.45
//  126 Hardware 34.95
//  127 Video 7.45
//  128 Book 14.32
//  129 Gasoline 16.10"
//
// The first line shows the original balance. Each other line (when not blank) gives information: check number, category, check amount.
//
// First you have to clean the lines keeping only letters, digits, dots and spaces.
// Then return a report as a string (underscores show spaces -- don't put them in your solution. They are there so you can see them and how many of them you need to have):
//  "Original_Balance:_1000.00
//  125_Market_125.45_Balance_874.55
//  126_Hardware_34.95_Balance_839.60
//  127_Video_7.45_Balance_832.15
//  128_Book_14.32_Balance_817.83
//  129_Gasoline_16.10_Balance_801.73
//  Total_expense__198.27
//  Average_expense__39.65"
//
// On each line of the report you have to add the new balance and then in the last two lines the total expense and the average expense.
// So as not to have a too long result string we don't ask for a properly formatted result.

import java.text.DecimalFormat;

public class EasyBalance {
    public static String balance(String book) {

        // Agarramos el input y lo filtramos en un array de strings para trabajarlo
        String[] lineas = book.replaceAll( "[^a-zA-z \\n0-9.]","").split("\n");

        // Formato de los decimales
        DecimalFormat f = new DecimalFormat("##.00");

        // Definimos las variables con las vamos a trabajar
        int lineasVacias = 0;
        double balance = Double.parseDouble(lineas[0]);
        String resultado = "Original Balance: " + f.format(balance) + "\\r\\n";
        double gastoTotal = 0;

        String[] compras = new String[lineas.length-1];
        System.arraycopy(lineas, 1, compras, 0, lineas.length-1);

        // Las cosas que hay que hacer para pasar los unit tests T_T
        for (String item : compras) {
            if (!item.matches(".*[a-z].*")) // Aca filtramos unit tests que te pasaban lineas llenas de espacios
                lineasVacias++;
            else {
                item = item.replaceAll("( )+", " ").trim();
                double precioDelItem = Double.parseDouble(item.substring(item.lastIndexOf(" ")));
                gastoTotal += precioDelItem;
                balance -= precioDelItem;
                resultado += item + " Balance " + f.format(balance) + "\\r\\n";
            }
        }

        // Agregamos las gasto total y el promedio
        resultado += "Total expense  " + f.format(gastoTotal) + "\\r\\nAverage expense  " + f.format(gastoTotal / (compras.length - lineasVacias));

        return resultado;
    }
}