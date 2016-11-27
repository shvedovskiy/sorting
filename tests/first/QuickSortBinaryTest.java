package first;
import main.Laba_2.second.ch2.Helper;
import main.Laba_2.second.ch2.QuickSortBinary;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class QuickSortBinaryTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MAX_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
                Helper.genSawtooh(10),
                Helper.genSawtooh(100),
                Helper.genSawtooh(1000),
                Helper.genSawtooh(10000),
                Helper.genIncreasing(10),
                Helper.genIncreasing(100),
                Helper.genIncreasing(1000),
                Helper.genIncreasing(10000),
                Helper.genDecreasing(10),
                Helper.genDecreasing(100),
                Helper.genDecreasing(1000),
                Helper.genDecreasing(10000),
                Helper.genZeros(1),
                Helper.genZeros(10),
                Helper.genZeros(100),
                Helper.genZeros(1000),
                Helper.genZeros(10000),
                Helper.genStagger(10, 5),
                Helper.genStagger(100, 10),
                Helper.genStagger(1000, 20),
                Helper.genStagger(10000, 50),
                Helper.genPlateau(10, 3),
                Helper.genPlateau(100, 33),
                Helper.genPlateau(1000, 200),
                Helper.genPlateau(10000, 3500),
        });
    }

    private boolean isSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1 && isSorted; i++) {
            isSorted = arr[i] <= arr[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkQuickSortBinary() throws IOException {
        Assert.assertTrue(isSorted(QuickSortBinary.quickSortBinary(Arrays.copyOf(array, array.length))));
    }
}
