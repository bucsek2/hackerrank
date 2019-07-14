package hu.bucsek2.data_structures.java_priority_queue;

import hu.bucsek2.TestBase;
import org.junit.Test;

public class SolutionTest extends TestBase {

    @Test
    public void test0() {
        String in = "12\n" +
                "ENTER John 3.75 50\n" +
                "ENTER Mark 3.8 24\n" +
                "ENTER Shafaet 3.7 35\n" +
                "SERVED\n" +
                "SERVED\n" +
                "ENTER Samiha 3.85 36\n" +
                "SERVED\n" +
                "ENTER Ashley 3.9 42\n" +
                "ENTER Maria 3.6 46\n" +
                "ENTER Anik 3.95 49\n" +
                "ENTER Dan 3.95 50\n" +
                "SERVED";
        String expected = "Dan\n" +
                "Ashley\n" +
                "Shafaet\n" +
                "Maria\n";
        test(in, expected);
    }

    @Override
    protected Runnable mainRunnable() {
        return () -> Solution.main(null);
    }
}