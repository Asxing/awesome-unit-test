package com.holddie;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Execution(ExecutionMode.CONCURRENT)
public class FirstTest {

    private static List<String> threadNames = Collections.synchronizedList(new ArrayList<>());

    @AfterAll
    static void afterAll() {

        Assumptions.assumeTrue(isParallelExecutionEnable());

        long count = threadNames.stream()
                .distinct()
                .count();

        assertThat(count).isEqualTo(2);
    }

    private static boolean isParallelExecutionEnable() {
        return !threadNames.isEmpty();
    }

    @Test
    void sabra() throws InterruptedException {
        Thread.sleep(4000);
        threadNames.add(Thread.currentThread().getName());
        System.out.println("SABRA! " + Thread.currentThread().getName());
    }

    @Test
    void cadabra() throws InterruptedException {
        Thread.sleep(3000);
        threadNames.add(Thread.currentThread().getName());
        System.out.println("SABRA! " + Thread.currentThread().getName());
    }
}
