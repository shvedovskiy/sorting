package main;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
        return arr;
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while ((i < left.length) && (j < right.length)) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        System.arraycopy(left, i, arr, k, left.length - i);
        System.arraycopy(right, j, arr, k, right.length - j);
    }
}
