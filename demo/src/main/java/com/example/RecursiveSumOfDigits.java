package com.example;

public class RecursiveSumOfDigits {

    /**
     * Calculates the sum of the digits of a given number recursively.
     *
     * @param number the non-negative integer to calculate the sum of its digits
     * @return the sum of the digits
     */
    public int sumOfDigits(int number) {
        if (number < 0) {
            number = Math.abs(number); // Convert negative to positive
        }

        if (number == 0) {
            return 0; // Base case
        }

        return (number % 10) + sumOfDigits(number / 10); // Recursive case
    }
}
