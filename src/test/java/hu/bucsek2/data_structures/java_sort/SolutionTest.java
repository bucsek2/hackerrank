package hu.bucsek2.data_structures.java_sort;

import hu.bucsek2.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "5\n" +
                "33 Rumpa 3.68\n" +
                "85 Ashis 3.85\n" +
                "56 Samiha 3.75\n" +
                "19 Samara 3.75\n" +
                "22 Fahim 3.76";
        String expected = "Ashis\n" +
                "Fahim\n" +
                "Samara\n" +
                "Samiha\n" +
                "Rumpa\n";
        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}