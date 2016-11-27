package main.Laba_2.second.ch2;

public class MSDBinary {
    private static final int BITWORD = 22;

    /**
     * Извлечение i-го байта из двоичного слова num
     */
    private static int digit(int num, int i) {
        return ((num >> (BITWORD - i)) & 1);
    }

    private static void msdSort(int[] arr, int[] res, int left, int right, int r) {
        if (left >= right || r > BITWORD){
            return;
        }
        int[] count = new int[3];
        for (int i = left; i <= right; ++i) {
            count[digit(arr[i], r)]++;
        }
        for (int i = 1; i != 3; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            count[digit(arr[i], r)] -= 1;
            res[left + count[digit(arr[i], r)]] = arr[i];
        }
        System.arraycopy(res, left, arr, left, right - left + 1);
        for (int i = 0; i != 2; ++i) {
            msdSort(arr, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }

    public static int[] msdSort(int arr[]) {
        int[] res = new int[arr.length];
        msdSort(arr, res, 0, arr.length - 1, 0);
        return res;
    }
}
