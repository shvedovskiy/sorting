package main;

public class QuickSortBinary {
    private static final int BITSWORD = 22;

    private static int digit(int num, int i) {
        return ((num >> (BITSWORD - i)) & 1);
    }

    private static void quickSortBinary(int[] arr, int left, int right, int d) {
        int i = left, j = right;
        if (left >= right || d > BITSWORD) {
            return;
        }
        while (j != i) {
            while (digit(arr[i], d) == 0 && (i < j)) {
                i++;
            }
            while (digit(arr[j], d) == 1 && (i < j)) {
                j--;
            }
            Helper.swap(arr, i, j);
        }
        if (digit(arr[right], d) == 0) {
            j++;
        }
        quickSortBinary(arr, left, j - 1, d + 1);
        quickSortBinary(arr, j, right, d + 1);
    }

    public static int[] quickSortBinary(int[] arr) {
        quickSortBinary(arr, 0, arr.length - 1, 0);
        return arr;
    }
}