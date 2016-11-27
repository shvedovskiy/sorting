package main.Laba_2.second.ch2;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i != arr.length; ++i) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; --j) {
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
