package com.codewars.Java;

// Take the following IPv4 address: 128.32.10.1
// This address has 4 octets where each octet is a single byte (or 8 bits).
// 1st octet 128 : 10000000, 2nd octet 32: 00100000, 3rd octet 10: 00001010, 4th octet 1: 00000001
// So 128.32.10.1 == 10000000.00100000.00001010.00000001
//
//Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
//
//Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.

import java.util.Arrays;
import java.util.List;

public class Int32toIPv4 {
    public static String longToIP(long ip) {
        // Arrancamos con un default por si el input es 0
        String[] resultado = {"0", "0", "0", "0"};

        String binary = Long.toBinaryString(ip);
        // Nos aseguramos de que tenga los 32 bits antes de parsearlo
        binary = (binary.length() == 32) ? binary :
                String.format("%1$" + 32 + "s", binary).replace(' ', '0');

        // Hacemos magia Regex y rompemos en octetos el input convertido a binario
        List<String> octates = Arrays.asList(binary
                .split("(?<=\\G.{" + 8 + "})")); // Regex vudú
        // Los valores que correspondan los appendeamos inversamente en la lista y la returneamos joineando con puntos :)
        for (int i = octates.size()-1; i >= 0; i--)
            resultado[i] = String.valueOf(Integer.parseInt(octates.get(i), 2));

        return String.join(".", resultado);
    }
}

// Las soluciones en CodeWars son cada vez mas irreales:
// public static String longToIP(long ip) {
//    return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
//  }