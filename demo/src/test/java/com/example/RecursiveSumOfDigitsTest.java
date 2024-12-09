package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecursiveSumOfDigitsTest {

    @Test
    void testPositiveNumbers() {
        RecursiveSumOfDigits recursiveSum = new RecursiveSumOfDigits();
        assertEquals(15, recursiveSum.sumOfDigits(12345));
        assertEquals(6, recursiveSum.sumOfDigits(123));
        assertEquals(1, recursiveSum.sumOfDigits(100));
    }

    @Test
    void testNegativeNumbers() {
        RecursiveSumOfDigits recursiveSum = new RecursiveSumOfDigits();
        assertEquals(15, recursiveSum.sumOfDigits(-12345));
        assertEquals(6, recursiveSum.sumOfDigits(-123));
        assertEquals(1, recursiveSum.sumOfDigits(-100));
    }

    @Test
    void testZero() {
        RecursiveSumOfDigits recursiveSum = new RecursiveSumOfDigits();
        assertEquals(0, recursiveSum.sumOfDigits(0));
    }

    @Test
    void testLargeNumbers() {
        RecursiveSumOfDigits recursiveSum = new RecursiveSumOfDigits();
        assertEquals(45, recursiveSum.sumOfDigits(99999));
        assertEquals(10, recursiveSum.sumOfDigits(1234));
    }
}
