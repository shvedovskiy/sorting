package main.Laba_2.second.ch2;

public class MSDStrings{
    private static final int BITWORD = Integer.MAX_VALUE;

    /**
     * Извлечение i-го байта из двоичного слова num
     */
    private static int character(String str, int i) {
        return i < str.length() ? str.charAt(i) : 0;
    }

    private static void msdSort(String[] arr, String[] res, int left, int right, int r) {
        if (left >= right || r > BITWORD) {
            return;
        }
        int[] count = new int[257];
        for (int i = left; i <= right; ++i) {
            count[character(arr[i], r)]++;
        }
        for (int i = 1; i != 257; ++i) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            count[character(arr[i], r)] -= 1;
            res[left + count[character(arr[i], r)]] = arr[i];
        }
        System.arraycopy(res, left, arr, left, right - left + 1);
        for (int i = 0; i != 256; ++i) {
            msdSort(arr, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }

    public static String[] msdSort(String[] arr) {
        String[] res = new String[arr.length];
        msdSort(arr, res, 0, arr.length - 1, 0);
        return res;
    }
}
