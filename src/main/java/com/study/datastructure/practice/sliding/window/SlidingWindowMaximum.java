package com.study.datastructure.practice.sliding.window;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;

/**
 * Sliding Window Maximum
 * Problem: Given an array and a window size k, find the maximum value in each sliding window.
 *
 * Input: [1,3,-1,-3,5,3,6,7], k = 3
 *
 * Output: [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {

    @Test
    public void testSlidingWindowMaximum() {
        assertArrayEquals("Input: [1, 3, -1, -3, 5, 3, 6, 7], k = 3",
                new int[]{3, 3, 5, 5, 6, 7},
                slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        assertArrayEquals("Input: [1], k = 1",
                new int[]{1},
                slidingWindowMaximum(new int[]{1}, 1));

        assertArrayEquals("Input: [4, 4, 4, 4, 4], k = 2",
                new int[]{4, 4, 4, 4},
                slidingWindowMaximum(new int[]{4, 4, 4, 4, 4}, 2));

        assertArrayEquals("Input: [2, 1, 3, 5, 4], k = 3",
                new int[]{3, 5, 5},
                slidingWindowMaximum(new int[]{2, 1, 3, 5, 4}, 3));

        assertArrayEquals("Input: [9, 7, 6, 4, 2], k = 3",
                new int[]{9, 7, 6},
                slidingWindowMaximum(new int[]{9, 7, 6, 4, 2}, 3));

        assertArrayEquals("Input: [1, 3, 5, 7, 2, 4], k = 2",
                new int[]{3, 5, 7, 7, 4},
                slidingWindowMaximum(new int[]{1, 3, 5, 7, 2, 4}, 2));

        assertArrayEquals("Input: [10, 9, 8], k = 3",
                new int[]{10},
                slidingWindowMaximum(new int[]{10, 9, 8}, 3));

    }

    private int[] slidingWindowMaximum(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int right = 0;
        List<Integer> result = new ArrayList<>();
        while (right < arr.length) {
            int current = arr[right];
            list.add(current);
            right += 1;
            if(list.size() == k) {
                int hightest  = new TreeSet<>(list).reversed().first();
                result.add(hightest);
                list.removeFirst();
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
