package com.codewars.Java;

// Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
// HH = hours, padded to 2 digits, range: 00 - 99
// MM = minutes, padded to 2 digits, range: 00 - 59
// SS = seconds, padded to 2 digits, range: 00 - 59
// The maximum time never exceeds 359999 (99:59:59)

import java.util.Arrays;
import java.util.List;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {

        int hours = seconds / 3600;
        int remainder = seconds - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;

        List<String> horaMinSec = Arrays.asList(String.format("%02d", hours), String.format("%02d", mins), String.format("%02d", secs));

        return String.join(":", horaMinSec);
    }
}

// Mejor respuesta en CodeWars:
//  public static String makeReadable(int seconds) {
//    return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
//  }