package com.cike.demo01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        int[] values = {3, 5, 6, 98, 1, 8996, 11};
        int temp = 0;
        for (int i = 0; i < values.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(Arrays.toString(values));
        }
    }

}
