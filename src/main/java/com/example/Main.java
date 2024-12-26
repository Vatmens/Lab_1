package com.example;

import java.util.List;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        RandomGenerator randomGen = RandomGenerator.getDefault();
        List<Integer> numbers = randomGen.ints(15, 0, 100).boxed().toList();

        System.out.print("Generated Numbers: ");
        displayList(numbers);

        System.out.println("Processing with Stream API:");
        processTasks(numbers, new StreamAPI());

        System.out.println("Processing with Parallel Stream API:");
        processTasks(numbers, new ParallelStream());
    }

    static void processTasks(List<Integer> numbers, InterfaceMethods taskHandler) {
        int total = taskHandler.sumInts(numbers);
        System.out.printf("Total Sum: %d\n", total);

        double mean = taskHandler.findAverage(numbers);
        System.out.printf("Mean Value: %.2f\n", mean);

        double stdDev = taskHandler.findStandardDeviation(numbers);
        System.out.printf("Standard Deviation: %.2f\n", stdDev);

        List<Integer> doubledNumbers = taskHandler.multiplyBy2(numbers);
        System.out.print("Doubled Numbers: ");
        displayList(doubledNumbers);

        List<Integer> divisibleBy3 = taskHandler.filterDivisibleBy3(numbers);
        System.out.print("Numbers Divisible by 3: ");
        displayList(divisibleBy3);
    }

    static void displayList(List<Integer> list) {
        list.forEach(num -> System.out.printf("%d ", num));
        System.out.println();
    }
}
