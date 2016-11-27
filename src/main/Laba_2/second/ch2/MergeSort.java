package main.Laba_2.second.ch2;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[arr.length];
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = right;
        int len = rightEnd - leftStart + 1;

        int i = leftStart;
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                tmp[i++] = arr[leftStart++];
            } else {
                tmp[i++] = arr[rightStart++];
            }
        }
        while (leftStart <= leftEnd) {
            tmp[i++] = arr[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmp[i++] = arr[rightStart++];
        }

        for (int j = 0; j != len; ++j, rightEnd--) {
            arr[rightEnd] = tmp[rightEnd];
        }
    }
}
