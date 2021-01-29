package com.navpreet.demo.array;

public class MergeSortedArray {

    private MergeSortedArray() {
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length <= 0) {
            return arr2;
        }
        if (arr2 == null || arr2.length <= 0) {
            return arr1;
        }

        var index1 = 0;
        var index2 = 0;
        var mergedIndex = 0;

        var mergedArray = new int[arr1.length + arr2.length];

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                mergedArray[mergedIndex++] = arr1[index1++];
            } else {
                mergedArray[mergedIndex++] = arr2[index2++];
            }
        }
        if (arr1.length != index1) {
            var size = arr1.length - index1;
            for (int i = 0; i < size; i++) {
                mergedArray[mergedIndex++] = arr1[index1++];
            }
        } else if (arr2.length != index2) {
            System.arraycopy(arr2, index2, mergedArray, mergedIndex, arr2.length - index2);
        }
        return mergedArray;
    }
}
