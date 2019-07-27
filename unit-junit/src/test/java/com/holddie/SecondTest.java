package com.holddie;

import org.junit.jupiter.api.Test;

class SecondTest {

    @Test
    void name() throws InterruptedException {
        System.out.println("one more! " + Thread.currentThread().getName());
        Thread.sleep(2000);
    }
}
