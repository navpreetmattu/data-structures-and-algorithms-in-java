package com.navpreet.demo;

import java.util.Arrays;

import com.navpreet.demo.array.MergeSortedArray;

public class Main {

    public static void main(String[] args) {
        int[] a1 = { 2, 5, 8, 12, 45, 77, 89, 98, 101, 102};
        int[] a2 = { 3, 5, 7, 23, 34, 78, 99, 100 };
        int[] a3 = MergeSortedArray.mergeSortedArrays(a1, a2);
        System.out.println(Arrays.toString(a3));
    }
}