package org.cmyers.euler.q1;

import java.util.HashSet;

class Main {
    public static final void main(String [] args) {
        // Find the sum of all the multiples of 3 or 5 below 1000.
        HashSet<Integer> ints = new HashSet<>();

        // calculate multiples of 3
        for(int i = 0, multiple = 0; multiple < 1000; multiple = i * 3, i++) {
            ints.add(multiple);
        }

        // calculate multiples of 5
        for(int i = 0, multiple = 0; multiple < 1000; multiple = i * 5, i++) {
            ints.add(multiple);
        }

        long sum = 0;
        for(Integer x : ints) {
            sum = sum + x;
        }

        System.out.println("Sum: " + sum);
    }
}

