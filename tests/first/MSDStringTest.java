/*package first;

import main.Laba_2.second.ch2.Helper;
import main.Laba_2.second.ch2.MSDStrings;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

@RunWith(value = Parameterized.class)
public class MSDStringTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public String[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Object[][] data() {
        return new Object[][] {
                Helper.genStrings(20, 10),
                Helper.genStrings(10, 2),
                Helper.genStrings(33, 20),
                Helper.genStrings(50, 25),
        };
    }

    private boolean isSorted(String[] arr) {
        return true;
    }

    @Test
    public void test01_checkMSDStrings() throws IOException {
        Assert.assertTrue(isSorted(MSDStrings.msdSort(array)));
    }
}*/
