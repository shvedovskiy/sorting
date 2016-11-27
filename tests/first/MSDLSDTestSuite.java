package first;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MSDBinaryTest.class,
        //MSDStringTest.class,
        LSDLongsTest.class,
})
public class MSDLSDTestSuite {
}
