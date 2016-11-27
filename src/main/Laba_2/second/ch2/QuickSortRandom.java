package main.Laba_2.second.ch2;

import java.util.Random;

public class QuickSortRandom {
    public static int[] quickSortRandom(int[] arr) {
        if (arr == null) {
            return new int[0];
        }
        quickSortRandom(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSortRandom(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        Random rand = new Random();
        int index = rand.nextInt(right - left + 1) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;
        int k = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < x) {
                j++;
                Helper.swap(arr, i , j);
            } else if (arr[i] == x) {
                k++;
                j++;
                Helper.swap(arr, i, j);
                Helper.swap(arr, k, j);
            }
        }

        int oldJ = j;
        for (int i = left; i <= k; i++) {
            Helper.swap(arr, i, j--);
        }

        quickSortRandom(arr, left, j);
        quickSortRandom(arr, oldJ + 1, right);
    }
}