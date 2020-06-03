package com.codewars;

// There is a queue for the self-checkout tills at the supermarket.
// Your task is write a function to calculate the total time required for all the customers to check out!
// Input:
//      customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
//      n: a positive integer, the number of checkout tills.
// Output:
//      The function should return an integer, the total time required.

import java.util.PriorityQueue;

public class SupermarketQueue {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0)
            return 0;

        // Buen ejercicio para implementar PrioritiyQueues
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < customers.length && i<n; i++)
            queue.offer(customers[i]);

        for (int i = n; i < customers.length; i++)
            queue.offer(queue.poll() + customers[i]);

        while (queue.size() != 1)
            queue.poll();

        return queue.poll();
    }
}

// Mejor respuesta en CodeWars (un crack, lo resuelve sin PQs):
// public static int solveSuperMarketQueue(int[] customers, int n) {
//      int[] result = new int[n];
//      for(int i = 0; i < customers.length; i++){
//        result[0] += customers[i];
//        Arrays.sort(result);
//      }
//      return result[n-1];
//    }