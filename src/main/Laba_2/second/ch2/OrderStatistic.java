package main.Laba_2.second.ch2;

import java.util.Random;

public class OrderStatistic {
    public static int findOrderStatistic(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (true) {
            if (left >= right) {
                return arr[left];
            }
            int mid = partition(arr, left, right);
            if (mid == k) {
                return arr[mid];
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        Random rand = new Random();
        int index = rand.nextInt(right - left) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; ++i) {
            if (arr[i] <= x) {
                j++;
                Helper.swap(arr, i , j);
            }
        }
        Helper.swap(arr, left, j);
        return j;
    }
}

