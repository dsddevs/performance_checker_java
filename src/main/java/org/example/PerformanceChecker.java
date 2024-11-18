package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.System.*;
import static java.lang.System.nanoTime;

public class PerformanceChecker {

    @Getter
    @AllArgsConstructor
    static class PerformanceResult<T> {
        private final String operationName;
        private final long durationNano;
        private final long durationMs;

        @Override
        public String toString() {
            return String.format("%s: duration: | %d - ns. | %d - ms.",
                    operationName, durationNano, durationMs
            );
        }

        public static <T> PerformanceResult<T> measurePerformance(String operationName, Runnable operation){

            long startNano = nanoTime();
            long startMs = currentTimeMillis();
            operation.run();
            long durationNano = nanoTime() - startNano;
            long durationMs = currentTimeMillis() - startMs;

            return new PerformanceResult<>(operationName, durationNano, durationMs);

        }
    }

}
