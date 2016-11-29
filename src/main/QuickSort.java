package main;

public class QuickSort {
    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid);
            quickSort(arr, mid + 1, right);
        } else {
            return;
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int mid = arr[left + (right - left + 1) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < mid) {
                i++; // слева направо
            }
            while (arr[j] > mid) {
                j--; // справа налево
            }
            // Нашли оба несовпадающих
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return j;
    }
}
