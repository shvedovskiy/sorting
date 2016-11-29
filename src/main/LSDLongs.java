package main;

public class LSDLongs {
    public static long[] lsdSort(long[] arr) {
        if (arr == null) {
            return new long[]{};
        }

        final int R = 1 << 8;
        final int mask = R - 1;
        final int w = 8;

        long[] tmp = new long[arr.length];

        for (int d = 0; d != w; ++d) {
            long[] counters = new long[R + 1];
            for (int i = 0; i != arr.length; ++i) {
                int c = (int) ((arr[i] >> 8 * d) & mask);
                counters[(c + 1)]++;
            }

            for (int r = 0; r < R; r++)
                counters[r + 1] += counters[r];

            if (d == w - 1) {
                long shift1 = counters[R] - counters[R / 2];
                long shift2 = counters[R / 2];
                for (int r = 0; r != R / 2; ++r)
                    counters[r] += shift1;
                for (int r = R / 2; r != R; ++r)
                    counters[r] -= shift2;
            }

            for (int i = 0; i != arr.length; ++i) {
                int c = (int) ((arr[i] >> 8 * d) & mask);
                tmp[(int) counters[c]++] = arr[i];
            }

            for (int i = 0; i != arr.length; ++i)
                arr[i] = tmp[i];
        }
        return arr;
    }
}
