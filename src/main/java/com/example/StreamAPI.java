package com.example;

import java.util.List;

public class StreamAPI implements InterfaceMethods {

    public StreamAPI() {}

    @Override
    public int sumInts(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).reduce(0, Integer::sum);
    }

    @Override
    public double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public double findStandardDeviation(List<Integer> numbers) {
        double average = this.findAverage(numbers);
        double variance = numbers.stream()
                .mapToDouble(num -> Math.pow(num - average, 2))
                .average()
                .orElse(0.0);
        return Math.sqrt(variance);
    }

    @Override
    public List<Integer> multiplyBy2(List<Integer> numbers) {
        return numbers.stream().map(num -> num * 2).toList();
    }

    // Filter integers that are divisible by 3 and even
    @Override
    public List<Integer> filterDivisibleBy3(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 3 == 0 && num % 2 == 0).toList();
    }
}