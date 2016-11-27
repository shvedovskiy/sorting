package main.Laba_2.second.ch2;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int i = 0;
        boolean changed = false;

        do {
            changed = false;
            for (int j = 0; j != arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    changed = true;
                }
            }
            i++;
        } while (changed);
        return arr;
    }
}
