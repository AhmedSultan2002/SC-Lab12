package com.example;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    /**
     * Recursive binary search for integers.
     *
     * @param arr    the sorted array of integers
     * @param target the target integer to search for
     * @param low    the starting index of the search range
     * @param high   the ending index of the search range
     * @return the index of the target if found, or -1 if not found
     */
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        if (low > high) {
            return -1; // Base case: range is empty
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1); // Search left half
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high); // Search right half
        }
    }

    /**
     * Recursive binary search for strings.
     *
     * @param arr    the sorted array of strings
     * @param target the target string to search for
     * @param low    the starting index of the search range
     * @param high   the ending index of the search range
     * @return the index of the target if found, or -1 if not found
     */
    public static int binarySearchRecursive(String[] arr, String target, int low, int high) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        if (low > high) {
            return -1; // Base case: range is empty
        }

        int mid = low + (high - low) / 2;

        if (arr[mid].equals(target)) {
            return mid; // Target found
        } else if (arr[mid].compareTo(target) > 0) {
            return binarySearchRecursive(arr, target, low, mid - 1); // Search left half
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high); // Search right half
        }
    }

    /**
     * Finds all indices of a target value in a sorted array using recursion.
     *
     * @param array  the sorted array of integers
     * @param target the target value to search for
     * @return a list of indices where the target value appears
     */
    public static List<Integer> findAllIndices(int[] array, int target) {
        List<Integer> indices = new ArrayList<>();
        findIndicesHelper(array, target, 0, array.length - 1, indices);
        indices.sort(Integer::compareTo); // Ensure the indices are sorted
        return indices;
    }

    /**
     * Helper method to recursively find indices of the target value.
     *
     * @param array   the sorted array of integers
     * @param target  the target value to search for
     * @param left    the starting index of the search range
     * @param right   the ending index of the search range
     * @param indices the list to store indices of the target value
     */
    private static void findIndicesHelper(int[] array, int target, int left, int right, List<Integer> indices) {
        if (left > right) {
            return; // Base case: search range is empty
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            indices.add(mid); // Add the index of the target
            findIndicesHelper(array, target, left, mid - 1, indices); // Search the left half
            findIndicesHelper(array, target, mid + 1, right, indices); // Search the right half
        } else if (array[mid] < target) {
            findIndicesHelper(array, target, mid + 1, right, indices); // Search the right half
        } else {
            findIndicesHelper(array, target, left, mid - 1, indices); // Search the left half
        }
    }
}
