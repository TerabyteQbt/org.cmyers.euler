package org.cmyers.euler.q7;

import java.util.BitSet;
import java.util.HashSet;

class Main {
    public static final void main(String[] args) {
        // find the 10,001st prime
        // 2,3,5,...
        // use a prime sieve
        // array of odd numbers
        // array[i] represents 2(i+2)-1
        // 0 => 3, 1 => 5, 2 => 7, etc
        // To turn a number into its index, therefore, ((N+1)/2)-2, so 7 => 2,
        // etc.
        // for each prime we have found, "mark" all of its' factors from the
        // array.  so for 3, mark 3, 6, 9, etc.
        int maxSieveSize = 1000000000;
        int primeWeWant = 10001;

        BitSet sieve = new BitSet(maxSieveSize/2);
        HashSet<Integer> primes = new HashSet<>();
        primes.add(2);
        System.out.println("Found prime: 2");

        int index = 0;

        while(primes.size() < 10001) {
            // first, find current value
            System.out.println("Starting from index " + index);
            index = sieve.nextClearBit(index);
            System.out.println("next clear index is " + index);
            int current = indexToInteger(index);
            System.out.println("Found prime: " + current);
            primes.add(current); // found this prime
            int factor = current;
            sieve.set(integerToIndex(factor));
            while(factor < maxSieveSize) {
                factor = factor + current;
                sieve.set(integerToIndex(factor));
            }
        }
    }

    private static int indexToInteger(int index) {
        return (index + 2) * 2 - 1;
    }

    private static int integerToIndex(int integer) {
        if(integer % 2 == 0) {
            return 0; // even numbers not valid
        }
        return ((integer + 1) / 2) - 2;
    }
}

