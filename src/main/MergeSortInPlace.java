package main;

public class MergeSortInPlace {
    public static int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int left, int right){
        if (right - left == 0){
        }
        else if (right - left == 1) {
            if (arr[left] > arr[right])
                Helper.swap(arr, left, right);
        }
        else {
            int mid = ((int) Math.floor((left + right) / 2));
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        while (i <= mid) {
            if (arr[i] > arr[mid + 1]) {
                Helper.swap(arr, i, mid + 1);
                push(arr, mid + 1, right);
            }
            i++;
        }
    }


    private static void push(int[] arr, int left, int right){
        for (int i = left; i != right; ++i){
            if (arr[i] > arr[i + 1])
                Helper.swap(arr, i, i + 1);
        }
    }
}


