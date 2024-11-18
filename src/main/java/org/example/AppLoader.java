package org.example;

import static org.example.PerformanceChecker.PerformanceResult.measurePerformance;

public class AppLoader {
    public static void main(String[] args) {


        var operation = measurePerformance("Operation name №1", () -> {
            // some operation
        });


    }
}
