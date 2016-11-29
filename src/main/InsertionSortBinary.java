package main;

public class InsertionSortBinary {
    public static int binarySearch(int[] arr, int key, int start, int end) {
        int left = start;
        int right = end;
        int mid;
        while (left < right) {
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
            int k = binarySearch(arr, arr[i], 0, i);
            int tmp = arr[i];
            for (int j = i - 1; j >= k; j--) {
                arr[j + 1] = arr[j];
            }
            arr[k] = tmp;
        }
        return arr;
    }
}
