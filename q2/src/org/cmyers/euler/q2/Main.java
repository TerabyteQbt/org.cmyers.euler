package org.cmyers.euler.q2;

class Main {
    public static final void main(String [] args) {
        // for fib numbers where n1 = 1, n2 = 2, ... find the sum of all even
        // valued terms under size 4 mil
        long maxTerm = 4000000;

        long a = 1;
        long b = 2;
        long sum = 2;
        while(b < maxTerm) {
            long c = a + b;
            a = b;
            b = c;
            if(c % 2 == 0) {
                sum = sum + c;
                System.out.println("Including term " + c + " so sum so far is " + sum);
            }
        }
        System.out.println("Sum of even fib numbers (starting at 1,2) under 4 mil is " + sum);
    }
}

