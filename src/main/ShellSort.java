package main;

public class ShellSort {
    public static int[] shellSort(int[] arr) {
        int gap = 1;
        while (gap < arr.length / 3) {
            gap = 3 * gap + 1;
        }
        while (gap > 0) {
            for (int i = gap; i != arr.length; ++i) {
                int tmp = arr[i];
                int j;
                for (j = i; j >= gap; j -= gap) {
                    if (tmp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                    } else {
                        break;
                    }
                }
                arr[j] = tmp;
            }
            gap /= 3;
        }
        return arr;
    }
}
