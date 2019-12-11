package dynamicprogramming;

import java.util.concurrent.TimeUnit;

public class Fibonacci {

    static int[] lookup = new int[100_000];

    public static int dynamicFibonacci(int a) {
        if (lookup[a] != 0)
            return lookup[a];

        if (a==2 || a==1)
            lookup[a] = 1;
        else
            lookup[a] = dynamicFibonacci(a-1) + dynamicFibonacci(a-2);

        return lookup[a];
    }

    public static int fibonacci(int a) {
        if (a==1 || a==2)
            return 1;
        else
            return fibonacci(a-1) + fibonacci(a-2);
    }

    public static void main(String[] args) {
        long startTimeDynamic = System.nanoTime();
        System.out.println(dynamicFibonacci(40));
        long endTimeDynamic = System.nanoTime();
        System.out.println("Execution time with DP (micro sec): " + TimeUnit.NANOSECONDS.toMicros(endTimeDynamic-startTimeDynamic));

        long startTimeRecur = System.nanoTime();
        System.out.println(fibonacci(40));
        long endTimeRecur = System.nanoTime();
        System.out.println("Execution time with recursion (micro sec): " + TimeUnit.NANOSECONDS.toMicros(endTimeRecur-startTimeRecur));
    }
}
