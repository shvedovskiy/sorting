package first;

import main.Helper;
import main.MSDStrings;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;

public class MSDStringTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private boolean isSorted(String[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; ++i) {
            isSorted = array[i].compareTo(array[i] + 1) <= 0;
        }
        return isSorted;
    }


    @Test
    public void test01_checkMSDStrings() throws IOException {
        Assert.assertTrue(isSorted(MSDStrings.msdSort(Helper.genStrings(10000, 200))));
    }

    @Test
    public void test02_checkMSDStrings() throws IOException {
        Assert.assertTrue(isSorted(MSDStrings.msdSort(Helper.genStrings(50000, 200))));
    }

    @Test
    public void test03_checkMSDStrings() throws IOException {
        Assert.assertTrue(isSorted(MSDStrings.msdSort(Helper.genStrings(100000, 200))));
    }
}
