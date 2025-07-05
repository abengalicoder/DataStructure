package com.study.datastructure.sorting;

import java.util.stream.Stream;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[]{4, 1, 6, 3, 2, 0});
        bubbleSort(new int[]{1,2,3,4,5,6,7,8});
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = true;

        for (int i = 0; i < arr.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
