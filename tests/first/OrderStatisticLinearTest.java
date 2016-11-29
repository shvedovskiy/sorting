package first;

import main.Helper;
import main.OrderStatisticLinear;
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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(value = Parameterized.class)
public class OrderStatisticLinearTest {
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
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
                Helper.genSawtooh(10),
                Helper.genSawtooh(100),
                Helper.genSawtooh(1000),
                Helper.genIncreasing(10),
                Helper.genIncreasing(100),
                Helper.genIncreasing(1000),
                Helper.genIncreasing(10000),
                Helper.genDecreasing(10),
                Helper.genDecreasing(100),
                Helper.genDecreasing(1000),
                Helper.genDecreasing(10000),
                Helper.genMaxMin(1),
                Helper.genMaxMin(10),
                Helper.genMaxMin(100),
                Helper.genMaxMin(1000),
                Helper.genZeros(1),
                Helper.genZeros(10),
                Helper.genZeros(100),
                Helper.genZeros(1000),
                Helper.genStagger(10, 5),
                Helper.genStagger(100, 10),
                Helper.genStagger(1000, 20),
                Helper.genStagger(10000, 50),
                Helper.genPlateau(10, 3),
                Helper.genPlateau(100, 33),
                Helper.genPlateau(1000, 200),
        });
    }

    @Test
    public void test01_checkOrderStatisticLinear() throws IOException {
        Random rand = ThreadLocalRandom.current();
        int pos = rand.nextInt(array.length);
        int k = OrderStatisticLinear.findOrderStatisticLinear(array, 0, array.length - 1, pos + 1);
        Arrays.sort(array);
        Assert.assertEquals(k, array[pos]);
    }
}
