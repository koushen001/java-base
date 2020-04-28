package com.cike.demo01;

import java.util.Arrays;

/**
 * 二分查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] values = {3, 5, 6, 98, 1, 8996, 11};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
        System.out.println(myBinarySearch(values, 11));
    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
