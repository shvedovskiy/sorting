package main;

public class MSDStrings {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String str, int d) {
        if (d < str.length()) {
            return str.charAt(d);
        } else {
            return -1;
        }
    }
    public static String[] msdSort(String[] arr)
    {
        int N = arr.length;
        aux = new String[N];
        msdSort(arr, 0, N-1, 0);
        return arr;
    }
    private static void msdSort(String[] array, int left, int right, int d)
    {
        if (right <= left + M) {
            insertionSort(array, left, right, d);
            return;
        }
        int[] counts = new int[R + 2];
        for (int i = left; i <= right; ++i) {
            counts[charAt(array[i], d) + 2]++;
        }
        for (int r = 0; r != R + 1; ++r) {
            counts[r + 1] += counts[r];
        }
        for (int i = left; i <= right; ++i) {
            aux[counts[charAt(array[i], d) + 1]++] = array[i];
        }
        for (int i = left; i <= right; ++i) {
            array[i] = aux[i - left];
        }
        for (int r = 0; r != R; ++r) {
            msdSort(array, left + counts[r], left + counts[r + 1] - 1, d + 1);
        }
    }

    private static void insertionSort(String[] arr, int left, int right, int d)
    {
        for (int i = left; i <= right; ++i) {
            for (int j = i; j > left && less(arr[j], arr[j - 1], d); j--) {
                Helper.swap(arr, j, j - 1);
            }
        }
    }
    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }
}
