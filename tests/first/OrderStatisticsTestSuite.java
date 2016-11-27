package first;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OrderStatisticTest.class,
        OrderStatisticLinearTest.class,
})
public class OrderStatisticsTestSuite {
}
