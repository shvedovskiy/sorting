package main.Laba_2.second.ch2;

public class InsertionSortBinary {
    public static int binarySearch(int[] arr, int key, int start, int end) {
        int left = start;
        int right = end;
        int mid;
        while (left < right) { // [left, right)
            mid= (left + right) / 2;
            if (key == arr[mid]) {
                return mid;
            } else {
                if (key < arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (key < arr[left]) {
            return left;
        }
        if (key > arr[right]) {
            return -1;
        }
        return right;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i - 1;
            int k = binarySearch(arr, arr[i], 0, i); // [0, i)
            for (int m = j; m >= k; m--) {
                if (k != -1) {
                    Helper.swap(arr, m, m + 1);
                }
            }
        }
        return arr;
    }
}
