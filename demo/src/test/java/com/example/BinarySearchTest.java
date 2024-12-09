package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class BinarySearchTest {

    @Test
    void testBinarySearchRecursiveInt() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearchRecursive(array, 5, 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, 10, 0, array.length - 1));
    }

    @Test
    void testBinarySearchRecursiveString() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(2, BinarySearch.binarySearchRecursive(array, "cherry", 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, "kiwi", 0, array.length - 1));
    }

    @Test
    void testFindAllIndices() {
        int[] array = {1, 2, 2, 2, 4};
        assertEquals(Arrays.asList(1, 2, 3), BinarySearch.findAllIndices(array, 2));
        assertEquals(Arrays.asList(), BinarySearch.findAllIndices(array, 5));
    }

    @Test
    void testErrorHandling() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearchRecursive(null, 5, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearchRecursive(new int[]{}, 5, 0, 0));
    }
}
