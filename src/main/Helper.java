package main;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();
    private static final Random rL = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swap(long[] a, int i, int j) {
        long x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swap(String[] a, int i, int j) {
        String x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = i;
        }
        for (int i = result.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(result, i, j);
        }
        return result;
    }

    public static long[] genLongs(int n) {
        long[] result = new long[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = i;
        }
        for (int i = result.length - 1; i > 0; i--) {
            int j = rL.nextInt(i + 1);
            Helper.swap(result, i, j);
        }
        return result;
    }

    public static int[] genIncreasing(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = i;
        }
        return result;
    }

    public static int[] genDecreasing(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = n - i;
        }
        return result;
    }

    public static int[] genSawtooh(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; i += 5) {
            result[i] = 0;
            result[i + 1] = 1;
            result[i + 2] = 2;
            result[i + 3] = 3;
            result[i + 4] = 4;
        }
        return result;
    }

    public static int[] genMaxMin(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length / 2; ++i){
            if (i <= result.length / 2) {
                result[i] = Integer.MAX_VALUE;
            } else {
                result[i] = Integer.MIN_VALUE;
            }
        }
        return result;
    }

    public static int[] genZeros(int n){
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i){
            result[i] = 0;
        }
        return result;
    }

    public static int[] genStagger(int n, int m) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = m * (i + 1) % n;
        }
        return result;
    }

    public static int[] genPlateau(int n, int m) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = Math.min(i, m);
        }
        return result;
    }

    public static int[] genAntiQuickSort(int n) {
        int[] result = new int[n];
        for (int i = 0; i != result.length; ++i) {
            result[i] = i + 1;
        }
        for (int i = 2; i != result.length; ++i) {
            Helper.swap(result, i, i / 2);
        }
        return result;
    }

    public static String[] genStrings(int count, int n) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String[] result = new String[count];

        for (int i = 0; i != count; ++i) {
            StringBuilder str = new StringBuilder();
            int size = rand.nextInt(n) + 1;
            for (int j = 0; j != size; ++j) {
                int pos = rand.nextInt(alphabet.length());
                str.append(alphabet.charAt(pos));
            }
            result[i] = str.toString();
        }
        return result;
    }

    public static String[] genMSDBest(int count, int n) {
        String[] result = Helper.genStrings(count, n);
        Arrays.sort(result);
        return result;
    }
}
