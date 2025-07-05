package com.study.datastructure.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        insertionSort(new int[]{4, 5, 9, 10, 6, 7, 8});
    }

    public static void insertionSort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for(int j = i; j >= 0; j--) {
                int temp = arr[j];
                if(temp > key) {
                    arr[j+1] = temp;
                    arr[j] = key;
                }
            }
        }

        System.out.println();
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
