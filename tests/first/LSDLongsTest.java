package first;

import main.Laba_2.second.ch2.Helper;
import main.Laba_2.second.ch2.LSDLongs;
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
public class LSDLongsTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                null,
                {1L, 2L, 3L, 4L},
                {6262L, 1434L, 135353L, 2353253L},
                Helper.genLongs(1),
                Helper.genLongs(10),
                Helper.genLongs(100),
                Helper.genLongs(1000),
                Helper.genLongs(10000),
        });
    }

    private boolean isSorted(long[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1 && isSorted; i++) {
            isSorted = arr[i] <= arr[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkLSDLongs() throws IOException {
        Assert.assertTrue(isSorted(LSDLongs.lsdSort(array)));
    }
}