package main;

public class OrderStatisticLinear {
    private static int findMedian(int[] arr, int left, int right) {
        sort(arr, left, right);
        return ((right + left) % 2 == 0) ? arr[(left + right - 1) / 2] : arr[(left + right) / 2];
    }

    public static int findOrderStatisticLinear(int[] arr, int left, int right, int k) {
        if (k > 0 && (k <= right - left + 1)) {
            int n = right - left + 1;
            int i;
            int[] meds = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++) {
                int m = left + 5 * i;
                meds[i] = findMedian(arr, m, m + 5);
            }

            if (i * 5 < n) {
                int m = left + i * 5;
                meds[i] = findMedian(arr, m, m + n % 5);
                i++;
            }

            int medOfMed = (i == 1)? meds[i-1]: findOrderStatisticLinear(meds, 0, i - 1, i / 2);
            int pos = partition(arr, left, right, medOfMed);

            if (pos-left == k-1) {
                return arr[pos];
            }

            if (pos-left > k-1) {
                return findOrderStatisticLinear(arr, left, pos - 1, k);
            }
            return findOrderStatisticLinear(arr, pos + 1, right, k - pos + left - 1);
        }
        return -1;
    }

    private static void sort(int[] arr, int left, int right) {
        for (int i = left + 1; i != right; ++i) {
            for (int j = i; j > left && arr[j] < arr[j - 1]; j--) {
                Helper.swap(arr, j, j - 1);
            }
        }
    }

    private static int partition(int[] arr, int left, int right, int x) {
        int i;
        for (i = left; i != right; ++i) {
            if(arr[i] == x) {
                break;
            }
        }
        Helper.swap(arr, i, right);

        i = left;
        for (int j = left; j <= right - 1; ++j) {
            if (arr[j] <= x) {
                Helper.swap(arr, i, j);
                i++;
            }
        }
        Helper.swap(arr, i, right);
        return i;
    }
}

