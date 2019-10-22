package hu.bucsek2.java.advanced.java_annotations;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {
    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }

    @Test
    public void test0() {
        String in = "3\n" +
                "SENIOR 75\n" +
                "JUNIOR 45\n" +
                "SENIOR 40";
        String expected = "Senior Member\n" +
                "Spend: 75\n" +
                "Budget Left: 25\n" +
                "Junior Member\n" +
                "Spend: 45\n" +
                "Budget Left: 5\n" +
                "Senior Member\n" +
                "Spend: 40\n" +
                "Budget Left: 60\n";
        test(in, expected);
    }

    @Test
    public void test2() {
        String in = "3\n" +
                "SENIOR 100\n" +
                "JUNIOR 50\n" +
                "JUNIOR 0";
        String expected = "Senior Member\n" +
                "Spend: 100\n" +
                "Budget Left: 0\n" +
                "Junior Member\n" +
                "Spend: 50\n" +
                "Budget Left: 0\n" +
                "Junior Member\n" +
                "Spend: 0\n" +
                "Budget Left: 50\n";
        test(in, expected);
    }
}