package com.study.datastructure.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        selectionSort(new int[] {1,2,3,4,5,6,7,8,9});
        selectionSort(new int[] {9,4,5,6,2,1});
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
